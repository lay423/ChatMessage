package com.example.app_2022_12_19_1.controller;

import com.example.app_2022_12_19_1.data.ChatMessage;
import com.example.app_2022_12_19_1.data.RsData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<ChatMessage> writeMessage(){
        ChatMessage message = new ChatMessage("홍길동", "안녕하세요");
        return new RsData("S-1", "메세지가 작성되었습니다.", message);
    }
}
