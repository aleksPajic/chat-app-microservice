package com.chat.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/message")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    SimpMessagingTemplate template;

    @GetMapping("/all")
    public List<ChatMessageDto> getAllMessages() {
        return chatMessageService.findAllMessages();
    }

    @PostMapping("/create")
    public HttpStatus create(@RequestBody() ChatMessageDto chatMessage) {
        try {
            chatMessageService.insert(chatMessage);
            template.convertAndSend("/message/updated", chatMessage);
            return HttpStatus.NO_CONTENT;
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("Error during parsing date.");
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @SendTo("/message/updated")
    public ChatMessageDto broadcastMessage(@Payload ChatMessageDto chatMessageDto) {
        return chatMessageDto;
    }
}
