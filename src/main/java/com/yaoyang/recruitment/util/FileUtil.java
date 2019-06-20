package com.yaoyang.recruitment.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileUtil {

    public static void main(String[] args) throws Exception {
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath() + "\\src\\main\\java\\com\\yaoyang\\recruitment";
        File entityFile = new File(courseFile + "\\entity");
        for (String entity : entityFile.list()) {
            String entityName = entity.split("\\.")[0];
            System.out.println(entityName);

            createRepositoryFile(courseFile, entityName);

            createServiceFile(courseFile, entityName);

            createServiceImplFile(courseFile, entityName);

            createControllerFile(courseFile, entityName);
        }
    }

    private static void createControllerFile(String courseFile, String entityName) throws IOException {
        File repositoryFile = new File(courseFile + "\\controller\\" + entityName + "Controller.java");
        if (!repositoryFile.exists()) {
            repositoryFile.createNewFile();
            FileOutputStream out = new FileOutputStream(repositoryFile);
            PrintStream p = new PrintStream(out);
            p.println("package com.yaoyang.recruitment.controller;");
            p.println();
            p.println("import org.springframework.web.bind.annotation.RestController;");
            p.println("import org.springframework.web.bind.annotation.RequestMapping;");
            p.println();
            p.println("@RestController");
            p.println("@RequestMapping(\"/api/" + entityName.toLowerCase() + "\")");
            p.println("public class " + entityName + "Controller{}");
            p.close();
            out.close();
        }
    }

    private static void createServiceImplFile(String courseFile, String entityName) throws IOException {
        File serviceImplFile = new File(courseFile + "\\service\\impl\\" + entityName + "ServiceImpl.java");
        if (!serviceImplFile.exists()) {
            serviceImplFile.createNewFile();
            FileOutputStream out = new FileOutputStream(serviceImplFile);
            PrintStream p = new PrintStream(out);
            p.println("package com.yaoyang.recruitment.service.impl;");
            p.println();
            p.println("import com.yaoyang.recruitment.enumeration.EntityStatus;");
            p.println("import org.springframework.stereotype.Service;");
            p.println("import com.yaoyang.recruitment.service." + entityName + "Service;");
            p.println("import org.springframework.beans.factory.annotation.Autowired;");
            p.println("import com.yaoyang.recruitment.repository." + entityName + "Repository;");
            p.println("import com.yaoyang.recruitment.entity." + entityName + ";");
            p.println("import java.util.Optional;");
            p.println("import java.util.Date;");
            p.println();
            p.println("@Service");
            p.println("public class " + entityName + "ServiceImpl implements " + entityName + "Service {");
            p.println();
            p.println("    @Autowired");
            p.println("    private " + entityName + "Repository " + entityName.toLowerCase() + "Repository;");
            p.println();
            p.println("    @Override");
            p.println("    public " + entityName + " findById(Long id){");
            p.println("        Optional<" + entityName + "> optional = " + entityName.toLowerCase() + "Repository.findById(id);");
            p.println("        return optional.isPresent() ? optional.get() : null;}");
            p.println();
            p.println("    @Override");
            p.println("    public " + entityName + " save(" + entityName + " " + entityName.toLowerCase() + "){");
            p.println("        return " + entityName.toLowerCase() + "Repository.saveAndFlush(" + entityName.toLowerCase() + ");}");
            p.println();
            p.println("    @Override");
            p.println("    public " + entityName + " update(" + entityName + " " + entityName.toLowerCase() + "){");
            p.println("        " + entityName.toLowerCase() + ".setUpdateDate(new Date());");
            p.println("        return " + entityName.toLowerCase() + "Repository.saveAndFlush(" + entityName.toLowerCase() + ");}");
            p.println();
            p.println("    @Override");
            p.println("    public void delete(" + entityName + " " + entityName.toLowerCase() + "){");
            p.println("        " + entityName.toLowerCase() + ".setUpdateDate(new Date());");
            p.println("        " + entityName.toLowerCase() + ".setEntityStatus(EntityStatus.DELETE);");
            p.println("        " + entityName.toLowerCase() + "Repository.saveAndFlush(" + entityName.toLowerCase() + ");}");
            p.println("}");
            p.close();
            out.close();
        }
    }

    private static void createServiceFile(String courseFile, String entityName) throws IOException {
        File serviceFile = new File(courseFile + "\\service\\" + entityName + "Service.java");
        if (!serviceFile.exists()) {
            serviceFile.createNewFile();
            FileOutputStream out = new FileOutputStream(serviceFile);
            PrintStream p = new PrintStream(out);
            p.println("package com.yaoyang.recruitment.service;");
            p.println();
            p.println("import com.yaoyang.recruitment.entity." + entityName + ";");
            p.println();
            p.println("public interface " + entityName + "Service {");
            p.println();
            p.println("    " + entityName + " findById(Long id);");
            p.println();
            p.println("    " + entityName + " save(" + entityName + " " + entityName.toLowerCase() + ");");
            p.println();
            p.println("    " + entityName + " update(" + entityName + " " + entityName.toLowerCase() + ");");
            p.println();
            p.println("    void delete(" + entityName + " " + entityName.toLowerCase() + ");");
            p.println("}");
            p.close();
            out.close();
        }
    }

    private static void createRepositoryFile(String courseFile, String entityName) throws IOException {
        File repositoryFile = new File(courseFile + "\\repository\\" + entityName + "Repository.java");
        if (!repositoryFile.exists()) {
            repositoryFile.createNewFile();
            FileOutputStream out = new FileOutputStream(repositoryFile);
            PrintStream p = new PrintStream(out);
            p.println("package com.yaoyang.recruitment.repository;");
            p.println();
            p.println("import com.yaoyang.recruitment.entity." + entityName + ";");
            p.println("import org.springframework.data.jpa.repository.JpaRepository;");
            p.println("import org.springframework.data.jpa.repository.JpaSpecificationExecutor;");
            p.println();
            p.println("public interface " + entityName + "Repository extends JpaRepository<" + entityName + ", Long>,JpaSpecificationExecutor<" + entityName + "> {}");
            p.close();
            out.close();
        }
    }
}
