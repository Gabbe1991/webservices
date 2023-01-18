package com.example.javawebservices.controller;

import com.example.javawebservices.dto.Post;
import com.example.javawebservices.dto.ResponseUser;
import com.example.javawebservices.entities.AppUser;
import com.example.javawebservices.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseUser createUser(@RequestBody AppUser appUser) {
        return userService.addUser(appUser);
    }

    @GetMapping("/users/{id}")
    public ResponseUser getUserByID(@PathVariable(value = "id") long userID) {
        return userService.findById(userID);
    }

    @PutMapping("/users/{id}")
    public ResponseUser updateUser(@PathVariable(value = "id") long userID,
                                   @RequestBody AppUser appUserDetails) {
        return userService.updateUser(appUserDetails, userID);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") long userID){
        userService.deleteUser(userID);
    }

    @PostMapping("/users/{id}/posts")
    public List<Post> getPosts(@PathVariable(value = "id") long userID){
        return userService.getAllPostFromUser(userID);
    }
}
