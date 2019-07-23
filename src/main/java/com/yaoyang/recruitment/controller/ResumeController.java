package com.yaoyang.recruitment.controller;

import com.yaoyang.recruitment.base.ApiResult;
import com.yaoyang.recruitment.base.ApiResultBuilder;
import com.yaoyang.recruitment.dto.ResumeDto;
import com.yaoyang.recruitment.entity.Resource;
import com.yaoyang.recruitment.entity.Resume;
import com.yaoyang.recruitment.enumeration.ResponseCode;
import com.yaoyang.recruitment.service.ResourceService;
import com.yaoyang.recruitment.service.ResumeService;
import com.yaoyang.recruitment.util.DateUtil;
import com.yaoyang.recruitment.util.StringUtil;
import com.yaoyang.recruitment.util.UploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Api(tags = "简历")
@RestController
@RequestMapping("/api/resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ResourceService resourceService;

    @PostMapping("/create")
    @ApiOperation(value = "创建简历-前段")
    public ApiResult creatResume(@RequestBody ResumeDto resumeDto) {
        Resume resume = new Resume();
        BeanUtils.copyProperties(resumeDto, resume);
        resumeService.save(resume);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS, resume);
    }

    @GetMapping("/list")
    @ApiOperation(value = "简历列表-后台")
    public ApiResult list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Resume> resumes = resumeService.findAll(page, size);
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS, resumes);
    }

    @PostMapping("/uploadRsume")
    @ApiOperation(value = "上传简历-前段")
    public ApiResult uploadRsume(Long resumeId, @RequestBody MultipartFile file) {
        if (file.isEmpty()) {
            return ApiResultBuilder.buildFailedResult(ResponseCode.PARAM_ILLEGAL);
        }
        // 拿到文件名
        String filename = file.getOriginalFilename();
        //String suffix = filename
        // 存放上传图片的文件夹
        File fileDir = UploadUtils.getResumeDirFile();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(fileDir.getAbsolutePath());
        System.out.println(filename);
        try {
            // 构建真实的文件路径
            String newFileName = getFileName() + filename.substring(filename.lastIndexOf("."), filename.length());
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + newFileName);
            System.out.println(newFile.getAbsolutePath());
            // 上传图片到 -》 “绝对路径”
            file.transferTo(newFile);
            Resource resource = new Resource();
            resource.setResumeId(resumeId);
            resource.setUrl(fileDir.getAbsolutePath() + File.separator + newFileName);
            resource.setName(newFileName);
            resourceService.save(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ApiResultBuilder.buildSuccessResult(ResponseCode.OPT_SUCCESS);
    }

    private String getFileName() {
        return DateUtil.getDate("yyyyMMddHHmmsss") + "_" + StringUtil.getRandomString(4);
    }

    public static void main(String[] args) {
        String s = "zhongguofengdaodeliyizhanbanzhijing_3744115.jpg";
        System.out.println(s.substring(s.lastIndexOf("."), s.length()));

    }
}
