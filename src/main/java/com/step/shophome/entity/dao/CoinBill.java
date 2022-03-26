package com.step.shophome.entity.dao;

import java.util.Date;

/**
 * Create By: Meng
 * Create Date: 202
 * Desc:
 */
public class CoinBill {
  public long id;
  public long time;
  public int unit;
  public String code;
  public String date;
  public double money;
  public String title;
  public String memo;

  public CoinBill(String code, String title, double money, int unit) {
    this.code = code;
    this.title = title;
    this.money = money;
    this.unit = unit;
    this.time = new Date().getTime();
  }
}
