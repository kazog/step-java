package com.step.shophome.entity.dao;

import java.util.List;

public class OrderDetail {
  public long id;
  public int status;
  public double money;
  public String code;
  public String title;
  public String memo;
  public List<Desc> list;

  public OrderDetail(String code, String title, double money, int status, List<Desc> list) {
    this.code = code;
    this.title = title;
    this.status = status;
    this.money = money;
    this.list = list;
  }

  public static class Desc {
    public String label;
    public String value;
    public String memo;
    public String code;
    public int type;

    public Desc(String label, String value, String memo) {
      this.label = label;
      this.value = value;
      this.memo = memo;
    }
    public Desc(String label, String value) {
      this.label = label;
      this.value = value;
    }
  }
}
