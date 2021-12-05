package com.chat.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private ChatAppRepository repository;

    public List<ChatMessage> findAllMessages() {
        return (List<ChatMessage>) repository.findAll();
    }

    public void insert(ChatMessageRequest chatMessage) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parsedDate = dateFormat.parse(chatMessage.datetimeCreated);
        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
        ChatMessage message = ChatMessage.builder()
                .username(chatMessage.username)
                .message(chatMessage.message)
                .datetimeCreated(timestamp)
                .build();
        repository.save(message);
    }
}
