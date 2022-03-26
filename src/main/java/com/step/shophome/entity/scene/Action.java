package com.step.shophome.entity.scene;

import java.util.Map;

public class Action {
  public int id;
  public int typeId; // 执行项目类型
  public int sceneId; // 场景id
  public String value; // 文字讲解
  public String url; // 媒体地址
  public Map<String, Object> params; // 请求参数
  public boolean hasMore; // 是否还有更多

  public Action(int id, int typeId, int sceneId ,String value, String url, Map<String, Object> params, boolean more) {
    this.id = id;
    this.typeId = typeId;
    this.sceneId = sceneId;
    this.value = value;
    this.url = url;
    this.params = params;
    this.hasMore = more;
  }
}
