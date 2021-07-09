package com.the.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {


    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //springwebsocket 4.1.5版本前默认支持跨域访问，之后的版本默认不支持跨域，需要设置.setAllowedOrigins("*")
        registry.addHandler(webSocketHandler(),"/websocket/socketServer.do")
                .addInterceptors(new SpringWebSocketHandlerInterceptor()).setAllowedOrigins("*");

        registry.addHandler(webSocketHandler(), "/sockjs/socketServer.do")
                .addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
    }

    @Bean
    public TextWebSocketHandler webSocketHandler(){

        return new SpringWebSocketHandler();
    }
}
