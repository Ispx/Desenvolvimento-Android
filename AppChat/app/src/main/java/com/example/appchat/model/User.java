package com.example.appchat.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String image;

    public User(String id,String name,String email,String password,String image){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }
}
