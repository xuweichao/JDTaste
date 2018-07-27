package com.jdtaste.jdtasteadmin.controller;

import com.jdtaste.common.domain.WrapMapper;
import com.jdtaste.common.domain.Wrapper;
import com.jdtaste.common.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @BelongsProject: JDTaste
 * @BelongsPackage: com.jdtaste.jdtasteadmin.controller
 * @Author: xuweichao
 * @CreateTime: 2018-07-09 15:05
 * @Description: 通用接口
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${file.upload.path}")
    private String fileUploadPath;

    @RequestMapping(value = "/")
    public String index() {
        return "SUCCESS";
    }

    @RequestMapping(value = "/imgUpload")
    public Wrapper imgUpload(HttpServletRequest req, MultipartHttpServletRequest multiReq)
            throws IOException {
        System.out.println("---" + fileUploadPath);

        MultipartFile file = multiReq.getFile("file");
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        String localFileName = MD5Util.md5(file.getInputStream()) + suffix;
        File localFile = new File(fileUploadPath + localFileName);
        if (!localFile.exists()) {
            localFile.createNewFile();

            FileOutputStream fos = new FileOutputStream(
                    localFile);
            FileInputStream fs = (FileInputStream) file.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fs.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            fos.close();
            fs.close();

        } else {
            log.info("文件已存在！！");
        }

        return WrapMapper.wrap(
                Wrapper.SUCCESS_CODE,
                Wrapper.SUCCESS_MESSAGE,
                "http://localhost:8080/img/" + localFileName);

    }
}
