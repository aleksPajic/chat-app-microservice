package com.chat.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("/all")
    public List<ChatMessage> getAllMessages() {
        return chatMessageService.findAllMessages();
    }

    @PostMapping("/create")
    public HttpStatus create(@RequestBody() ChatMessageRequest chatMessage) {
        chatMessageService.insert(chatMessage);
        return HttpStatus.NO_CONTENT;
    }
}
