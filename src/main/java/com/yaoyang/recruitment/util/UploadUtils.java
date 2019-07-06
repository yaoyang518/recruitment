package com.yaoyang.recruitment.util;

import java.io.File;

public class UploadUtils {

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认） 
    public final static String RESUME_PATH_PREFIX = "file/upload/resume";

    public final static String IMG_PATH_PREFIX = "file/upload/img";

    public static File getImgDirFile(){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

    public static File getResumeDirFile(){

        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/resources/" + RESUME_PATH_PREFIX);

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }
}