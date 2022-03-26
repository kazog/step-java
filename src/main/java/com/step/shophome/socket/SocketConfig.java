package com.step.shophome.socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Create By: Meng
 * Create Date: 202
 * Desc: 
 * ws://192.168.8.107:9736/socke?user=1291923
 */

@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {
  @Autowired
  private SocketHandler socketHandler;
  @Autowired
  private SocketInterceptor socketInterceptor;

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(socketHandler, "socke").addInterceptors(socketInterceptor).setAllowedOrigins("*");
  }
}
