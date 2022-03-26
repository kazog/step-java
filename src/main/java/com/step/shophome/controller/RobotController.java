package com.step.shophome.controller;

import com.step.shophome.config.error.EnumError;
import com.step.shophome.entity.dao.AppToken;
import com.step.shophome.entity.result.DataResult;
import com.step.shophome.utils.crypto.AES;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot/app")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class RobotController extends BaseController{

  // 更新app
  @RequestMapping(value = "update", method = RequestMethod.GET)
  public DataResult complete(@RequestParam("token") String token) throws Exception {
    if(token.equals("qinlan2021-1")) {
      return DataResult.succee("http://8.133.188.219/");
    }
    return DataResult.create(EnumError.NOT_UPDATE);
  }
  
  // 获取初始化参数
  @RequestMapping(value = "getToken", method = RequestMethod.GET)
  public DataResult getToken(@RequestParam("uid") String uid, @RequestParam("code") String code) {
    // 根据不同的机器人返回不同的标识
    String tokenStr = AES.encrypt(uid + code, AES.KRY);
    AppToken token = new AppToken("1.0.01", tokenStr, code);
    return DataResult.succee(token);
  }
}
