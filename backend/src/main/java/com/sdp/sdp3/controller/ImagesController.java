package com.sdp.sdp3.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import com.sdp.sdp3.entities.Images;
import com.sdp.sdp3.repository.ImagesRepository;

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
public class ImagesController {
    @Autowired
    private ImagesRepository repository;

    @PostMapping("/image")
    public boolean postImage(@RequestBody Images img) {
        if(img.getAuthorName()!=null && !img.getAuthorName().equals("")) {
            // System.out.println(user);
            // System.out.println(img.getImageName()+" "+img.getImageUrl()+" "+img.getLocalDateTime()+" "+img.getHash_tags());
            Date today = new Date(); LocalDateTime ldt = LocalDateTime.ofInstant(today.toInstant(), ZoneId.systemDefault());
            img.setLocalDateTime(ldt);
            System.out.println("Adding Image Data");
            repository.save(img);
            return true;
        }
        else {
            System.out.println("User not logged in!");
            return false;
        }
    }
    
    @GetMapping("/image")
    public List<Images> getImage() {
        return repository.findAll();
    }

    @GetMapping("/feed")
    public List<Images> getFeed() {
        System.out.println("Sending image data!");
        return repository.findAll();
    }
}
