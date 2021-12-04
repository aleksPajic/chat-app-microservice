package com.chat.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private ChatAppRepository repository;

    public List<ChatMessage> findAllMessages() {
        return (List<ChatMessage>)repository.findAll();
    }

    public void insert(ChatMessageRequest chatMessage) {
        ChatMessage message = ChatMessage.builder()
                .username(chatMessage.username)
                .message(chatMessage.message)
                .datetimeCreated(new Timestamp(chatMessage.datetimeCreated))
                .build();
        repository.save(message);
    }
}
