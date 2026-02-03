package com.social.media.platform.controllers;

import com.social.media.platform.models.SocialUser;
import com.social.media.platform.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping(path = "/social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return ResponseEntity.ok(socialService.getAllUsers());
    }

    @PostMapping(path = "/social/users")
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser socialUser){
        return ResponseEntity.ok(socialService.createUser(socialUser));
    }


}
