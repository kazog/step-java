package com.step.shophome.entity.dao;

/**
 * Create By: Meng
 * Create Date: 202
 * Desc:
 */
public class Coin {
  public String userId;
  public String code; // 账号
  public double balance; // 余额
  public double topUp; // 充值
  public double amountPaid; // 支出
  public double frozen; // 冻结
  
  public Coin(String code, double balance, double topUp, double amountPaid, double frozen) {
    this.code = code;
    this.balance = balance;
    this.topUp = topUp;
    this.amountPaid = amountPaid;
    this.frozen = frozen;
  }
}
