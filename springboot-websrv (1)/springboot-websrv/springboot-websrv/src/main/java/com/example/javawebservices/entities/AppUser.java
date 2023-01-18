package com.example.javawebservices.entities;

import javax.persistence.*;

@Entity
public class AppUser {

    @Id
    private long userID;
    @Column(name = "Username")
    private String username;
    @Column(name = "emailAddress")
    private String emailAddress;
    @Column(name = "password")
    private String password;

    public AppUser(String username, String emailAddress, String password) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
