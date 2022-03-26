package com.step.shophome.config.error;

public enum EnumError implements AppError {
  UNKOWN_ERROR(50001, "未知错误"),
  NOT_PARAM_ERROR(10008, "参数格式不正确或为空"),
  NOT_UPDATE(10010, "已是最新版！"),
  NOT_UID_ERROR(10002, "账号有误"),
  NOT_AUTO_ERROR(10001, "账号或密码错误"),
  FLOW_ERROR(20001, "流程错误"),
  OK(200, "成功"),
  ;

  private int code = 0;
  private String msg;

  private EnumError(int code, String msg) {
    this.code = code;
    this.msg = msg;
  } 

  @Override
  public int getErrCode() {
    return code;
  }

  @Override
  public String getErrMsg() {
    return msg;
  }

  @Override
  public AppError setErrMsg(String msg) {
    this.msg = msg;
    return this;
  }
}
