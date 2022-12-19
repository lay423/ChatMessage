package com.example.app_2022_12_19_1.controller;

import com.example.app_2022_12_19_1.data.ChatMessage;
import com.example.app_2022_12_19_1.data.RsData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private List<ChatMessage> chatMessageList = new ArrayList<>();

    @AllArgsConstructor
    @Getter
    public static class WriteMessageRequest {
        private final String authorName;
        private final String content;
    }

    @AllArgsConstructor
    public static class writeMessageResponse{
        private final long id;
    }

    @PostMapping("/writeMessage")
    @ResponseBody
    public RsData<writeMessageResponse> writeMessage(@RequestBody WriteMessageRequest req){
        ChatMessage message = new ChatMessage(req.getAuthorName(), req.getContent());

        chatMessageList.add((message));

        return new RsData(
                "S-1",
                "메세지가 작성되었습니다.",
                message.getId());
    }

    @GetMapping("/messages")
    @ResponseBody
    public RsData<List<ChatMessage>> messages(){

        return new RsData<>(
                "S-1",
                "메세지가 작성되었습니다.",
                chatMessageList);
    }

    @GetMapping("/messagesById")
    @ResponseBody
    public RsData<List<ChatMessage>> messagesById(@RequestParam(value="id") int id) {
        List<ChatMessage> getMessages = new ArrayList<>();
        for (int i = id; i < chatMessageList.size(); i++) {
            getMessages.add(chatMessageList.get(i));
        }
        return new RsData<>(
                "S-1",
                "메세지가 작성되었습니다.",
                getMessages);
    }
}
