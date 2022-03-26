package com.step.shophome.entity.scene;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By Meng
 * Desc: 
 */

public class Scene {
  public int id; // 
  public String name;
  public List<Action> actions;
  public boolean disturb; // 免打扰

  public Scene(int id, String name, boolean disturb, List<Action> actions) {
    this.id = id;
    this.name = name;
    this.actions = actions;
    this.disturb = disturb;
  }

  // 
  public static Scene getScene(String id, String code) {
    List<Action> actions = new ArrayList<>();
    actions.add(new Action(101, 1, 1001, "帕奇，你好", "url", null, true));
    actions.add(new Action(102, 1, 1001, "欢迎虚拟员工帕奇", "url", null, true));
    actions.add(new Action(103, 1, 1001, "你好帕奇，介绍一下你自己", "url", null, true));
    actions.add(new Action(104, 1, 1001, "谢谢帕奇，给大家介绍一下我们博士工作站", "url", null, true));
    actions.add(new Action(105, 1, 1001, "谢谢，请放一下实验室宣传视频", "url", null, false));

    actions.add(new Action(106, 1, 1002, "你好，我是调度员付晶", "url", null, false));
    actions.add(new Action(106, 1, 1002, "好的，请开始", "url", null, false));
    actions.add(new Action(107, 1, 1002, "启动应急预案", "url", null, false));
    actions.add(new Action(108, 1, 1002, "白马0223A", "url", null, false));
    actions.add(new Action(109, 1, 1002, "好的", "url", null, false));
    actions.add(new Action(110, 1, 1002, "继续", "url", null, false));

    actions.add(new Action(111, 1, 1003, "你好，我是运检班龚成尧", "url", null, false));
    actions.add(new Action(112, 1, 1003, "好的，请开始", "url", null, false));
    actions.add(new Action(113, 1, 1003, "收到，请帮我检查故障间隔并明确设备型号。", "url", null, false));
    actions.add(new Action(114, 1, 1003, "好的", "url", null, false));
    actions.add(new Action(115, 1, 1003, "收到，到现场大概多少时间？", "url", null, false));
    actions.add(new Action(116, 1, 1003, "好的，谢谢帕奇。", "url", null, false));
    actions.add(new Action(117, 1, 1003, "好的，请打开单兵作业监护功能", "url", null, false));
    Scene scene = new Scene(1001, "电力系统讲解", true, actions);
    return scene;
  }
}
