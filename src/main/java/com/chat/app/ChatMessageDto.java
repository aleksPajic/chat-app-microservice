package com.chat.app;

import lombok.*;

@Setter()
@Getter()
@Builder()
@NoArgsConstructor()
@AllArgsConstructor()
public class ChatMessageDto {
    public String username;

    public String message;

    public String datetimeCreated;
}
