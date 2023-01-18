package com.example.javawebservices.service;

import com.example.javawebservices.dto.Post;
import com.example.javawebservices.dto.ResponseUser;
import com.example.javawebservices.entities.AppUser;
import com.example.javawebservices.repository.appUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;

@Service
public class UserService {


    private final WebClient webClient;

    private final appUserRepository appUserRepo;


    public UserService(WebClient webClient, appUserRepository appUserRepo) {
        this.webClient = webClient;
        this.appUserRepo = appUserRepo;
    }

///AAAAA
    public List<AppUser> getAllUsers() {
        return appUserRepo.findAll();
    }

    public ResponseUser addUser(AppUser appUser) {
        AppUser newUser = appUserRepo.save(new AppUser(appUser.getUsername(),
                appUser.getPassword(),
                appUser.getEmailAddress()));
        return new ResponseUser(newUser.getUserID(), newUser.getUsername());
    }

    public ResponseUser findById(long userID) {
        AppUser appUser = appUserRepo.getReferenceById(userID);
        return new ResponseUser(appUser.getUserID(), appUser.getUsername());
    }

    public ResponseUser updateUser(AppUser appUser, long id) {
        AppUser savedAppUser = appUserRepo.getReferenceById(id);

        if (appUser.getUsername() != null) {
            savedAppUser.setUsername(appUser.getUsername());
        }
        if (appUser.getEmailAddress() != null) {
            savedAppUser.setEmailAddress(appUser.getEmailAddress());
        }
        if (appUser.getPassword() != null) {
            savedAppUser.setPassword(appUser.getPassword());
        }
        appUserRepo.save(savedAppUser);
        return new ResponseUser(savedAppUser.getUserID(), savedAppUser.getUsername());
    }

    public void deleteUser(long id) {
        appUserRepo.deleteById(id);
    }

    public List<Post> getAllPostFromUser(long id) {
        return webClient.get()
                .uri("users/" + id + "/posts")
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Post.class))
                .buffer()
                .blockLast();
    }
}
