package com.chat.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @PostMapping("/add")
    public HttpStatus addMessage() {
        return HttpStatus.OK;
    }

}
