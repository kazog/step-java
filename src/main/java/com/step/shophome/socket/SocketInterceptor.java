package com.step.shophome.socket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * Create By: Meng
 * Create Date: 202
 * Desc:
 */

@Component
public class SocketInterceptor implements HandshakeInterceptor {

  // 在握手之前调用
  @Override
  public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
      Map<String, Object> attributes) throws Exception {
    // 获得请求参数
    String params = request.getURI().getQuery();
    System.out.println("SocketInterceptor ============》beforeHandshake：" + params);
    return true;
  }

  // 在握手完成后调用
  @Override
  public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
      Exception exception) {
    System.out.println("SocketInterceptor ============》afterHandshake：");
  }
}
