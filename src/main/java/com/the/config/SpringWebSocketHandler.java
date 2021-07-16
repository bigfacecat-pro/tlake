package com.the.config;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpringWebSocketHandler extends TextWebSocketHandler {
    private static Logger logger = Logger.getLogger(SpringWebSocketHandler.class);
    private static final Map<String, WebSocketSession> users;  //Map来存储WebSocketSession，key用USER_ID 即在线用户列表
    private static final String USER_ID = "WEBSOCKET_USERID";   //对应监听器从的key

    static {
        users =  new HashMap<String, WebSocketSession>();
    }

    public SpringWebSocketHandler() {}

    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        String userId = (String) session.getAttributes().get(USER_ID);
        users.put(userId,session);

    }

    /**
     * 关闭连接时触发
     */
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.debug("关闭websocket连接");
        String userId= (String) session.getAttributes().get(USER_ID);
        users.remove(userId);
    }

    /**
     * js调用websocket.send时候，会调用该方法
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        if(message.getPayload().startsWith("#anyone#")){ //单发某人
            sendMessageToUser((String)session.getAttributes().get(USER_ID), new TextMessage("服务器单发：" +message.getPayload())) ;
        }else if(message.getPayload().startsWith("#everyone#")){
            broadCast(new TextMessage("服务器群发：" +message.getPayload()));
        }else{
        }

    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        logger.debug("传输出现异常，关闭websocket连接... ");
        String userId= (String) session.getAttributes().get(USER_ID);
        users.remove(userId);
    }

    public boolean supportsPartialMessages() {

        return false;
    }


    /**
     * 给某个用户发送消息
     *
     * @param userId
     * @param message
     */
    public void sendMessageToUser(String userId, TextMessage message) {
        for (String id : users.keySet()) {
            if (id.equals(userId)) {
                try {
                    if (users.get(id).isOpen()) {
                        users.get(id).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    /**
     * 给所有在线用户发送消息
     *
     * @param message
     */
    public void broadCast(TextMessage message) {
        for (String userId : users.keySet()) {
            try {
                if (users.get(userId).isOpen()) {
                    users.get(userId).sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
