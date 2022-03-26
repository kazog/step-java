package com.step.shophome.controller;

import com.step.shophome.entity.result.DataResult;
import com.step.shophome.utils.FileUtil;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/files")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class FileController {
  
  // 上传图片
  @RequestMapping("/upload")
  public DataResult fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("bucket") String bucket) {
    try {
      System.out.println(bucket);
      String fileName = file.getOriginalFilename();
      System.out.println(fileName);
      String name = fileName.replace(".jpg", "&");
      name = name.substring(name.lastIndexOf(".") + 1, name.length());
      name = name.replace("&", ".jpg");

      String path = FileUtil.saveFile(name, file.getInputStream());
      System.out.println(path);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
    return DataResult.create(-3, "上传失败！");
  }

  // 上传图片
  @RequestMapping("/download")
  public DataResult fileDownload(@RequestParam("name") String fileName) {

    return DataResult.create(-3, "下载失败！");
  }
}
