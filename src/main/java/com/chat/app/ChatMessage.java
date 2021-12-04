package com.chat.app;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "username")
    public String username;

    @Column(name = "message_text")
    public String message;

    @Column(name = "datetime_created")
    public Timestamp datetimeCreated;
}
