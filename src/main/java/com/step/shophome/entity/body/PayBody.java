package com.step.shophome.entity.body;

import java.util.List;

public class PayBody {
  private double money;
  private double price;
  private int count;
  private int payType;
  private List items;

  @Override
  public String toString() {
    return money + "-" + price+ "-" + count+ "-" + payType;
  }
}
