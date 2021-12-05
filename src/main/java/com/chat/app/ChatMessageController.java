package com.chat.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        try {
            chatMessageService.insert(chatMessage);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("Error during parsing date.");
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.NO_CONTENT;
    }
}
