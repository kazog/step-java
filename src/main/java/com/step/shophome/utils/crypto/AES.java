package com.step.shophome.utils.crypto;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {

  // 默认的加密算法
  private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

  private static final String KEY_ALGORITHM = "AES";
  public static final String KRY = "-2911078525598212104";

  // public static void main(String[] str) {
  //   String content = "hello,您好";

  //   String key = "-2911078525598212104";
  //   String ks = getAESRandomKey();
  //   System.out.println("密钥=====》" + ks);
  //   String s1 = encrypt(content, key);
  //   System.out.println("加密结果=" + s1);
  //   System.out.println("解密结果=" + decrypt(s1, key));
  // }

  // 随机生成密钥
  public static String getAESRandomKey() {
    SecureRandom random = new SecureRandom();
    long randomKey = random.nextLong();
    return String.valueOf(randomKey);
  }

  /**
   * AES 加密操作
   *
   * @param content 待加密内容
   * @param key     加密密钥
   */
  public static String encrypt(String content, String key) {
    try {
      // 创建密码器
      Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
      byte[] byteContent = content.getBytes("utf-8");
      // 初始化为加密模式的密码器
      cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));
      // 加密
      byte[] result = cipher.doFinal(byteContent);
      // 通过Base64转码返回 - 解密的时候需要byte2Base64(result)
      return byte2Base64(result);
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  /**
   * AES 解密操作
   *
   * @param content
   * @param key
   */
  public static String decrypt(String content, String key) {
    try {
      // 实例化
      Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
      // 使用密钥初始化，设置为解密模式
      cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
      // 执行操作
      byte[] result = cipher.doFinal(base642Byte(content));
      return new String(result, "utf-8");
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return null;
  }

  /**
   * 生成加密秘钥
   */
  private static SecretKeySpec getSecretKey(final String key) {
    // 返回生成指定算法密钥生成器的 KeyGenerator 对象
    try {
      KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
      // 此类提供加密的强随机数生成器 (RNG)，该实现在windows上每次生成的key都相同，但是在部分linux或solaris系统上则不同。
      // SecureRandom random = new SecureRandom(key.getBytes());
      // 指定算法名称，不同的系统上生成的key是相同的。
      SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
      random.setSeed(key.getBytes());
      // AES 要求密钥长度为 128
      kg.init(128, random);
      // 生成一个密钥
      SecretKey secretKey = kg.generateKey();
      // 转换为AES专用密钥
      return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    } catch (NoSuchAlgorithmException ex) {
      ex.printStackTrace();
    }
    return null;
  }

  // 字节数组转Base64编码
  public static String byte2Base64(byte[] bytes) {
    // BASE64Encoder encoder = new BASE64Encoder();
    return Base64.getEncoder().encodeToString(bytes);
  }

  // Base64编码转字节数组
  public static byte[] base642Byte(String base64Key) {
    return Base64.getDecoder().decode(base64Key);
  }
}
