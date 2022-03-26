package com.step.shophome.entity.dao;

import java.util.Date;

public class Order {
  public long id;
  public int status;
  public int orderType;
  public double price;
  public String pic;
  public String code;
  public long time;
  public String name;
  public String title;
  
  public String memo;

  public Order(String title, String name, String pic, String code, int orderType, int status) {
    this.id = new Date().getTime();
    this.time = this.id;
    this.title = title;
    this.name = name;
    this.pic = pic;
    this.code = code;
    this.orderType = orderType;
    this.status = status;
  }

  
}
