package com.step.shophome.entity.result;

import java.util.List;

public class ListData {
  public int total;
  public int size;
  public int position;
  public int pageSize;
  public int pageNum;
  public boolean hasMore;
  public List<Object> list;

  public ListData(List<Object> list, int total, int pageSize, int pageNum) {
    this.total = total;
    this.position = pageNum;
    this.pageSize = pageSize;
    this.pageNum = pageNum;
    this.list = list;
    this.size = (int) Math.ceil(total / pageSize);
    this.hasMore = total > pageNum * pageSize;
  }

  public static ListData create(List<Object> list, int total, int pageSize, int pageNum) {

    return new ListData(list, total, pageSize, pageNum);
  }

}
