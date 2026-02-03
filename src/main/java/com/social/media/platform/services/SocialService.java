package com.social.media.platform.services;

import com.social.media.platform.models.SocialUser;
import com.social.media.platform.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser createUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }
}
