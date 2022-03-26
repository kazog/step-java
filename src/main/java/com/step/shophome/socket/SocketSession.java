package com.step.shophome.socket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.socket.WebSocketSession;

/**
 * Create By: Meng 
 * Create Date: 202 
 * Desc:
 */

public class SocketSession {
  // ws://192.168.8.107:8093/socke?
  private ConcurrentHashMap<String, WebSocketSession> sessionMap;

  private SocketSession() {
    System.out.println("SocketSession ============》init");
    // TextMessage msg = new TextMessage(" 消息 " + payload);
    // session.sendMessage(msg);
    sessionMap = new ConcurrentHashMap<String, WebSocketSession>();
  }

  public static SocketSession instance() {
    return SessionBuild.map;
  }

  // 单例-静态内部类
  private static class SessionBuild {
    public static final SocketSession map = new SocketSession();
  }

  // 添加
  public void add(String key, WebSocketSession session) {

    if (sessionMap.containsKey(key)) {
      return;
    }
    sessionMap.put(key, session);
  }

  // 获取
  public WebSocketSession get(String key) {
    if (sessionMap.containsKey(key)) {
      return sessionMap.get(key);
    }
    return null;
  }

  // 移除
  public void remove(String key) {
    try {
      if (!sessionMap.containsKey(key)) {
        return;
      }
      sessionMap.remove(key);
    } catch (Exception e) {
      System.out.println("SocketSession ============》remove：" + e.getMessage());
    }
  }

  // 关闭
  public void close(String key) {
    if (!sessionMap.containsKey(key)) {
      return;
    }
    WebSocketSession session = sessionMap.get(key);
    sessionMap.remove(key);
    try {
      session.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (String token : sessionMap.keySet()) {
      System.out.println("SocketSession ============》close：" + token);
    }
  }

}
