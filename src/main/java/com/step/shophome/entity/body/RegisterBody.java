package com.step.shophome.entity.body;

public class RegisterBody {
  
  private String realName;
  private String name;
  private String phone;
  private String email;
  private int platform;
  private int code;
  
  public RegisterBody(String realName, String name, String phone, String email, int platform) {
    this.realName = realName;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.platform = platform;
  }
  public int getCode() {
    return code;
  }
  public String getRealName() {
    return realName;
  }
  public void setRealName(String realName) {
    this.realName = realName;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public int getPlatform() {
    return platform;
  }
  public void setPlatform(int platform) {
    this.platform = platform;
  }
  public void setCode(int code) {
    this.code = code;
  }


}
