package com.chat.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatMessageService {
    @Autowired
    private ChatAppRepository repository;

    public List<ChatMessageDto> findAllMessages() {
        final Sort sort = Sort.by(Sort.Direction.ASC, "datetimeCreated");
        final List<ChatMessage> messages = repository.findAll(sort);
        return messages.stream().map((message) -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm");
            String dateTime = dateFormat.format(message.getDatetimeCreated());
            return ChatMessageDto.builder()
                    .username(message.getUsername())
                    .message(message.getMessage())
                    .datetimeCreated(dateTime)
                    .build();
        }).collect(Collectors.toList());
    }

    public void insert(ChatMessageDto chatMessage) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
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
