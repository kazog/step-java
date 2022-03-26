package com.step.shophome.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.step.shophome.config.error.EnumError;
import com.step.shophome.entity.dao.Coin;
import com.step.shophome.entity.dao.CoinBill;
import com.step.shophome.entity.result.DataResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By: Meng
 * Create Date: 202 Desc:
 */
@RestController
@RequestMapping("/api/coin")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class CoinController extends BaseController {

  // 获取详情
  @RequestMapping(value = "info", method = RequestMethod.GET)
  public DataResult getInfo(@RequestParam("user") String user) {
    long time = new Date().getTime();
    Coin coin = new Coin(user.toUpperCase() + time, 123013.12, 12323.34, 2352.56, 235.23);
    return DataResult.succee(coin);
  }

  // 获取账单
  @RequestMapping(value = "bill", method = RequestMethod.GET)
  public DataResult getBill(@RequestParam("billType") int bill) {
    List<Object> list = new ArrayList<>();
    if (bill == 1) {
      list.add(new CoinBill("OAJ1234545113", "材料费", 20000, 1));
      list.add(new CoinBill("OAJ2314356776", "人工费", 30000, 1));
      list.add(new CoinBill("OAJ8124913994", "团建费", 999, 1));
      list.add(new CoinBill("OAJ9104389189", "下午茶", 100, 1));
    } else if (bill == 2) {
      list.add(new CoinBill("OAJ0192939191", "定金", 100, 0));
      list.add(new CoinBill("OAJ3547241246", "吃饭补贴", 300, 2));
      list.add(new CoinBill("OAJ4645723563", "交通补贴", 399, 2));
      list.add(new CoinBill("OAJ5624141313", "话费补贴", 299, 2));
      list.add(new CoinBill("OAJ6723424114", "年终奖", 66600, 2));
    } else {
      list.add(new CoinBill("OAJ0192939191", "定金", 100, 0));
      list.add(new CoinBill("OAJ1234545113", "材料费", 20000, 1));
      list.add(new CoinBill("OAJ2314356776", "人工费", 30000, 1));
      list.add(new CoinBill("OAJ3547241246", "吃饭补贴", 300, 2));
      list.add(new CoinBill("OAJ4645723563", "交通补贴", 399, 2));
      list.add(new CoinBill("OAJ5624141313", "话费补贴", 299, 2));
      list.add(new CoinBill("OAJ6723424114", "年终奖", 66600, 2));
      list.add(new CoinBill("OAJ8124913994", "团建费", 999, 1));
      list.add(new CoinBill("OAJ9104389189", "下午茶", 100, 1));
    }
    return DataResult.succee(list);
  }
}
