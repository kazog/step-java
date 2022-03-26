package com.step.shophome.utils;

import jakarta.servlet.http.HttpServletRequest;

import java.io.*;
import java.net.URLEncoder;

/**
 * 文件读取工具类
 */
public class FileUtil {
  // public static String FILE_PATH = "C:Project/AppFiles"; // windows路径
  public static String FILE_PATH = "res/files"; // Mac路径
  public static String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";
  /**
   * 读取文件内容，作为字符串返回
   */
  public static String readFileAsString(String filePath) throws IOException {
    File file = new File(filePath);
    if (!file.exists()) {
      throw new FileNotFoundException(filePath);
    }

    if (file.length() > 1024 * 1024 * 1024) {
      throw new IOException("File is too large");
    }

    StringBuilder sb = new StringBuilder((int) (file.length()));
    // 创建字节输入流
    FileInputStream fis = new FileInputStream(filePath);
    // 创建一个长度为10240的Buffer
    byte[] bbuf = new byte[10240];
    // 用于保存实际读取的字节数
    int hasRead = 0;
    while ((hasRead = fis.read(bbuf)) > 0) {
      sb.append(new String(bbuf, 0, hasRead));
    }
    close(fis);
    return sb.toString();
  }

  /**
   * 根据文件路径读取byte[] 数组
   */
  public static byte[] readFileByBytes(String filePath) throws IOException {
    File file = new File(filePath);
    if (!file.exists()) {
      throw new FileNotFoundException(filePath);
    } else {
      ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
      BufferedInputStream in = null;
      try {
        in = new BufferedInputStream(new FileInputStream(file));
        short bufSize = 1024;
        byte[] buffer = new byte[bufSize];
        int len1;
        while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
          bos.write(buffer, 0, len1);
        }
        byte[] var7 = bos.toByteArray();
        return var7;
      } finally {
        close(in);
        close(bos);
      }
    }
  }

  /**
   * 输出指定文件的byte数组
   * 
   * @param fileName 文件名
   * @param fis       输入流
   */
  public static String saveFile(String path, String fileName, InputStream fis) {
    FILE_PATH = path;
    return saveFile(fileName, fis);
  }
  public static String saveFile(String fileName, InputStream fis) {
    FileOutputStream fos = null;
    String path = null;
    try {
      File file = new File(FILE_PATH);
      if (!file.exists()) {
        file.mkdirs();
      }
      file = new File(FILE_PATH, fileName);
      path = file.getAbsolutePath();
      fos = new FileOutputStream(file);
      byte[] b = new byte[2048];
      int length;
      while ((length = fis.read(b)) > 0) {
        fos.write(b, 0, length);
      }
      fos.flush();
    } catch (IOException e) {
      e.printStackTrace();;
    } finally {
      close(fos);
      close(fis);
    }
    return path;
  }


  /**
   * 下载文件名重新编码
   * 
   * @param request  请求对象
   * @param fileName 文件名
   * @return 编码后的文件名
   */
  public static String setFileDownloadHeader(HttpServletRequest request, String fileName)
      throws UnsupportedEncodingException {
    final String agent = request.getHeader("USER-AGENT");
    String filename = fileName;
    if (agent.contains("MSIE")) {
      // IE浏览器
      filename = URLEncoder.encode(filename, "utf-8");
      filename = filename.replace("+", " ");
    } else if (agent.contains("Firefox")) {
      // 火狐浏览器
      filename = new String(fileName.getBytes(), "ISO8859-1");
    } else if (agent.contains("Chrome")) {
      // google浏览器
      filename = URLEncoder.encode(filename, "utf-8");
    } else {
      // 其它浏览器
      filename = URLEncoder.encode(filename, "utf-8");
    }
    return filename;
  }

  /**
   * 文件名称验证
   * 
   * @param filename 文件名称
   * @return true 正常 false 非法
   */
  public static boolean isValidFilename(String filename) {
    return filename.matches(FILENAME_PATTERN);
  }

  private static void close(Closeable io) {
    try{
      if(io != null) {
        io.close();
      }
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}
