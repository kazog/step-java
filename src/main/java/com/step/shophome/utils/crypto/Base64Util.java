package com.step.shophome.utils.crypto;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Util {

  // public static void main(String[] str) {
  //   String content = "hello,您好";
  //   String s1 = encode(content);
  //   System.out.println("加密结果=" + s1);
  //   System.out.println("解密结果=" + decode(s1));
  // }

  /***
   * BASE64解密
   */
  public static String decode(String base64) {
    try {
      // 解码
      byte[] decodedBytes = Base64.getDecoder().decode(base64);
      return new String(decodedBytes, "utf-8");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static byte[] decode2(String base64) {
    try {
      // 解码
      byte[] decodedBytes = Base64.getDecoder().decode(base64);
      return decodedBytes;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  /***
   * BASE64加密
   */
  public static String encode(String str) {
    // 使用基本编码-输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
    String encodedString = "";
    try {
      encodedString = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return encodedString;
  }

  /***
   * BASE64加密
   */
  public static byte[] encode2(String str) {
    // 使用基本编码-输出被映射到一组字符A-Za-z0-9+/，编码不添加任何行标，输出的解码仅支持A-Za-z0-9+/。
    byte[] encodedString = null;
    try {
      encodedString = Base64.getEncoder().encode(str.getBytes("utf-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return encodedString;
  }

  // 其他方式加密
  public static String encodeToString(String str) {
    String base64 = null;
    try {
      // Base64 编码字符串 (URL)-输出映射到一组字符A-Za-z0-9+_，输出是URL和文件
      base64 = Base64.getUrlEncoder().encodeToString(str.getBytes("utf-8"));
      System.out.println("Base64 编码字符串 (URL) :" + base64);


      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < 10; ++i) {
        stringBuilder.append(UUID.randomUUID().toString());
      }
      byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
      // Base64 编码字符串 (MIME)-输出隐射到MIME友好格式。输出每行不超过76字符，并且使用'\r'并跟随'\n'作为分割。编码输出最后没有行分割
      return Base64.getMimeEncoder().encodeToString(mimeBytes);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return base64;
  }
}
