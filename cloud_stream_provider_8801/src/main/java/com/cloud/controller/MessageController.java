package com.cloud.controller;

import com.cloud.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/9
 */
@RestController
public class MessageController {

    @Autowired
    IMessageService messageService;

    @GetMapping("/send")
    public String send() {
        messageService.send();
        return null;
    }
}
