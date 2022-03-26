package com.step.shophome.controller;

import com.step.shophome.config.error.AppException;
import com.step.shophome.config.error.EnumError;
import com.step.shophome.entity.body.RegisterBody;
import com.step.shophome.entity.result.DataResult;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class AccountController extends BaseController{

  // 登陆
  @RequestMapping(value = "login", method = RequestMethod.GET)
  public DataResult login(@RequestParam("name") String name) throws Exception {
    System.out.println("account============>login:");
    // 登陆
    if(Integer.valueOf(name) > 0) {
      // throw AppException.create(EnumError.NOT_PARAM_ERROR);
    }
    
    return DataResult.create(EnumError.NOT_PARAM_ERROR);
  }
  
  // 退出登陆
  @RequestMapping(value = "logout")
  public DataResult logout() {
    // 退出登陆
    return DataResult.succee("退出成功！");
  }

  // 注册
  @RequestMapping(value = "register", method = RequestMethod.POST)
  public DataResult register(@RequestBody RegisterBody body) throws Exception {
    // 注册
    if(body.getName() != null) {
      body.getName().length();
    }
    return DataResult.succee("退出成功！");
  }

  // 注销账号
  public DataResult unsubscribe() {
    // 注销账号
    return DataResult.succee("账号已删除！");
  }
}
