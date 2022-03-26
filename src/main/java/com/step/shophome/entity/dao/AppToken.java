package com.step.shophome.entity.dao;

public class AppToken {
  public String version;
  public String token;
  public String code;
  
  public AppToken(String version, String token, String code) {
    this.version = version;
    this.token = token;
    this.code = code;
  }
}
