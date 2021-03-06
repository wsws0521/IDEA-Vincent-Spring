package cn.spring.websocket.controller;

import cn.spring.websocket.service.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 通过后台发送消息
 */
@RestController
@RequestMapping("socket")
public class SocketTestController {
    @Autowired
    private Socket socket;

    @GetMapping("/{message}")
    public void sendMessage(@PathVariable("message") String message) throws IOException {
        socket.sendMessage("这个是controller 发送的消息："+message);
    }
}
