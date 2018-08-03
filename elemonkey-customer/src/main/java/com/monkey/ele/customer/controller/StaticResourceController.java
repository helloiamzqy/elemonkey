package com.monkey.ele.customer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author Burgess Li
 * @version 1.0
 * @date 8/3/2018 9:38 AM
 **/
@RestController
@PropertySource(value = "classpath:common.properties", ignoreResourceNotFound = true)
public class StaticResourceController {

    @Value("${local_upload_files_folder}")
    private String uploadFolderPath;

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws Exception {
        String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        file.transferTo(new File(new File(uploadFolderPath), fileName));
        return fileName.substring(0, fileName.lastIndexOf(".")) + "-" + fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @RequestMapping("/resource/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable String fileName) throws Exception {
        fileName = fileName.substring(0, fileName.lastIndexOf("-")) + "." + fileName.substring(fileName.lastIndexOf("-") + 1);
        File file = new File(new File(uploadFolderPath), fileName);
        if (file.exists()) {
            return ResponseEntity.ok()
                    .contentLength(file.length())
                    .header("Content-Type", Files.probeContentType(Paths.get(file.toURI())))
                    .body(new FileSystemResource(file));
        }
        return null;
    }

}
