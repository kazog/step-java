package com.step.shophome.config.error;

public class AppException extends Exception implements AppError {
  private static final long serialVersionUID = 9736L;

  private AppError appError;

  public AppException(AppError appError) {
    this.appError = appError;
  }

  public static AppException create(AppError appError) {
    return new AppException(appError);
  }

  public AppException(AppError appError, String msg) {
    this.appError = appError;
    this.appError.setErrMsg(msg);
  }

  @Override
  public int getErrCode() {
    return appError.getErrCode();
  }

  @Override
  public String getErrMsg() {
    return appError.getErrMsg();
  }

  @Override
  public AppError setErrMsg(String message) {
    return appError.setErrMsg(message);
  }
  
}
