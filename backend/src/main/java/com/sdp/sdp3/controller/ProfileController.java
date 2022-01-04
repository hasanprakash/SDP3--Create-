package com.sdp.sdp3.controller;

import java.util.List;

import com.sdp.sdp3.entities.Profile;
import com.sdp.sdp3.repository.ImagesRepository;
import com.sdp.sdp3.repository.ProfileRepository;

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
public class ProfileController {
    @Autowired
    private ProfileRepository repository;

    @PostMapping("/profile")
    public boolean postSaved(@RequestBody Profile profile) {
        System.out.println(profile.getUsername()+" " + profile.getImageName() +" "+profile.getImages());
        repository.save(profile);
        System.out.println("Image Saved to user Profile");
        return true;
    }

    @GetMapping("/profile")
    public List<Profile> getSaved(String username) {
        return repository.findByUsername(username);
    }
}
