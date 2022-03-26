package com.step.shophome.controller;

import java.util.ArrayList;
import java.util.List;

import com.step.shophome.config.error.EnumError;
import com.step.shophome.entity.body.PayBody;
import com.step.shophome.entity.dao.Order;
import com.step.shophome.entity.dao.OrderDetail;
import com.step.shophome.entity.dao.PayItem;
import com.step.shophome.entity.dao.OrderDetail.Desc;
import com.step.shophome.entity.result.DataResult;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By: Meng
 * Create Date: 202
 * Desc:
 */
@RestController
@RequestMapping("/api/order")
// @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
public class OrderController extends BaseController{

  // 获取订单列表
  @RequestMapping("list")
  public DataResult orderList(@RequestParam("pageNum") int num, @RequestParam("pageSize") int size) {
    // System.out.println("============>orderList:"+num);
    List<Object> list = new ArrayList<>();
    if(num < 3) {
      list.add(new Order("华有雨·大象城", "吃嘛嘛香", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA128312381231", 1, 2));
      list.add(new Order("吃选优品", "油哈哈", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA4782894911", 0, 1));
      list.add(new Order("长沙臭豆腐", "小麦冰淇淋", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA974988271", 2, 0));
      list.add(new Order("赵昌集团", "有个定律", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA3992020345", 0, 0));
      list.add(new Order("河边有鱼", "炉子生火", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA56862922434", 1, 2));
      list.add(new Order("飞天茅台", "辣条·配花生", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA02042958689", 2, 1));
      list.add(new Order("沙丘·基地", "卡牌炮手", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA13211958689", 1, 1));
      list.add(new Order("商铺玩笑", "恒大·有房", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MK425789201010", 0, 2));
      list.add(new Order("万达·健林", "撕葱有你", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA0363465231", 2, 1));
      list.add(new Order("皮卡小球", "多拉多梦", "https://cn.bing.com/th?id=OHR.NewtonPumpkins_ZH-CN2560195971_1920x1080.jpg&rf=LaDigue_1920x1080.jpg", "MKA4563452342389", 1, 2));
    }
    return DataResult.list(list, 20, size, num);
  }
  
  // 支付订单
  @RequestMapping(value = "pay", method = RequestMethod.POST)
  public DataResult orderPay(@RequestBody PayBody body) {
    System.out.println(body.toString());
    return DataResult.succee("token");
  }

  // 支付列表
  @RequestMapping("verify")
  public DataResult orderVerify() {
    List<PayItem> list = new ArrayList<>();

    list.add(new PayItem(0, 100, "定金", "sha"));
    list.add(new PayItem(1, 2999, "人工费", "sha"));
    list.add(new PayItem(2, 1999, "材料费", "sha"));
    return DataResult.succee(list);
  }

  // 订单详情
  @RequestMapping("detail")
  public DataResult orderDetail(@RequestParam("id") long id) {
    
    List<Desc> list = new ArrayList<>();
    if(id % 2 == 0) {
      list.add(new Desc("商品说明", "多米多了又一个很很长很长"+id, "有退款"));
    }else{
      list.add(new Desc("商品说明", "米拉库拉很长很长很长很长很长很长很长很长"+id));
    }
    list.add(new Desc("支付方式", id % 2 == 0 ? "支付宝" : "微信"));
    list.add(new Desc("支付时间", "2021-10-21 19:20:10"));
    list.add(new Desc("订单号", "KAH123123124123"));
    list.add(new Desc("支付订单号", "AH9273490286419"));

    OrderDetail detail = new OrderDetail("KAH123123124123", "龙阳路先锋点", 1929.12, 1, list);
    return DataResult.succee(detail);
  }

}
