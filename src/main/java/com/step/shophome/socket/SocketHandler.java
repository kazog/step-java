package com.step.shophome.socket;

import java.io.IOException;

import com.google.gson.Gson;
import com.step.shophome.entity.result.DataResult;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Create By: Meng 
 * Create Date: 202 
 * Desc:
 * ws://192.168.8.107:9736/socke?user=1291923
  
    const socket = new WebSocket('ws://192.168.253.110:9736/socke?user=' + Date.now());
    socket.onopen = () => {
      console.log('============>open')
    }
    socket.onmessage = (e) => {
      const msg = JSON.parse(e.data);
      console.log(msg)
    }
    socket.onerror = (e) => {
      console.log(e)
    }
    socket.onclose = () => {
      console.log('===========close')
    }
    const msg = {
        toUser: 1231231231231,
        message: '啥哈哈哈哈'
      }
    socket.send(JSON.stringify(msg))
 */

@Component
public class SocketHandler extends TextWebSocketHandler {


  // 解析传人的参数
  private String parseUser(String query) {
    if (query != null && query.length() < 1) {
      return "请登录为登录";
    }
    if (query.indexOf("=") < 0) {
      return "掺入参数不合规范! 参数: ws://xxx.xxx.xxx.xxx:xxx/socke?id=1231231";
    }
    return query.substring(query.lastIndexOf("=") + 1, query.length());
  }

  // 建立连接成功
  @Override
  public void afterConnectionEstablished(WebSocketSession session) {
    // Object token = session.getAttributes().get("token"); session.getId();
    // session.getRemoteAddress().getHostName(); session.getUri().toString();
    String user = parseUser(session.getUri().getQuery());

    SocketSession.instance().add(user, session);
    System.out.println("SocketHandler =============》afterConnectionEstablished：" + user);
    sendMessage(session, user);
  }

  // 接收消息
  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) {
    // 获得客户端传来的消息
    String payload = message.getPayload();
    String token = session.getUri().getQuery();
    handlerMessage(token, payload);
  }

  // 断开连接
  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
    String token = parseUser(session.getUri().getQuery());;
    if (token != null) {
      // 用户退出，移除缓存
      System.out.println("SocketHandler ==============》afterConnectionClosed：" + token);
      SocketSession.instance().remove(token);
    }
  }

  // 处理接收到的消息
  private void handlerMessage(String token, String payload) {
    System.out.println("SocketHandler ==============》handleTextMessage：" + payload);
    WebSocketSession session = SocketSession.instance().get(payload);
    if(session != null) {
      sendMessage(session, payload + "给你发了一条消息！");
    }
  }

  // 发送消息
  private void sendMessage(WebSocketSession session, Object data) {
    DataResult result = DataResult.succee(data);

    Gson gson = new Gson();
    String text = gson.toJson(result);
    TextMessage msg = new TextMessage(text);
    try {
      System.out.println("SocketHandler ==============》sendMessage：" + text);
      session.sendMessage(msg);
    } catch (IOException e) {
      System.out.println("SocketHandler ==============》sendMessage Exception 消息发送失败！" + e.getMessage());
    }

  }
}
