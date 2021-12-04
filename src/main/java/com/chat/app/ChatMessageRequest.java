package com.chat.app;

import lombok.Getter;
import lombok.Setter;

@Setter()
@Getter()
public class ChatMessageRequest {
    public String username;

    public String message;

    public Long datetimeCreated;
}
