package com.step.shophome.entity.dao;

public class PayItem {
  public long id;
  public String title;
  public double money;
  public String memo;

  public PayItem(long id, double money, String title, String memo) {
    this.id = id;
    this.money = money;
    this.title = title;
    this.memo = memo;
  }
}
