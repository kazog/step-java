package com.step.shophome.config.error;

public interface AppError {
  int getErrCode();
  String getErrMsg();
  AppError setErrMsg(String message);
}
