package com.social.media.services;
import com.social.media.controllers.SocialController;
import org.slf4j.Logger;
import com.social.media.models.SocialUser;
import com.social.media.repositories.SocialUserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    private Logger log = LoggerFactory.getLogger(SocialService.class);
    @Autowired
    SocialUserRepository socialUserRepository;


    public List<SocialUser> getAllUsers() {
        log.info("inside SocialService::getAllUsers");
        return socialUserRepository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        log.info("inside SocialService::saveUser: {}", socialUser);
        return socialUserRepository.save(socialUser);
    }


    public SocialUser deleteUser(Long userId) {
        log.info("Inside SocialService::deleteUser: userId = " + userId);
        SocialUser socialUser = socialUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        socialUserRepository.delete(socialUser);
        return socialUser;
    }
}
