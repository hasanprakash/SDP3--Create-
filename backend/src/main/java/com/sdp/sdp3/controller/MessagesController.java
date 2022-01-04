package com.sdp.sdp3.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.sdp.sdp3.entities.Messages;
import com.sdp.sdp3.repository.MessagesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = { "http://localhost:8081", "https://mango-pebble-0e6f6c200.azurestaticapps.net/" })
public class MessagesController {

    @Autowired
    private MessagesRepository repository;

    @PostMapping("/message")
    public List<Messages> postMessage(@RequestBody Messages message) {
        System.out.println(message.getMessage()+" "+message.getIsFriend());
        Date today = new Date(); LocalDateTime ldt = LocalDateTime.ofInstant(today.toInstant(), ZoneId.systemDefault());
        message.setLocalDateTime(ldt);
        if(message.getUsername()==null || !message.getUsername().equals("")) {
            repository.save(message);
            return repository.findAll();
        }
        else  {
            System.out.println("User didn't logged in yet!!");
            List<Messages> EmptyList = Collections.<Messages>emptyList();  
            return EmptyList;
        }
    }

    @GetMapping("/message")
    public List<Messages> getMessages() {
        return repository.findAll();
    }
    
}
