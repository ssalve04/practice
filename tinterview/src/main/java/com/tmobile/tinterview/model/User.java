package com.tmobile.tinterview.model;

import java.util.List;

public class User {

    Integer id;
    String name;
    String username;
    String email;
    List<Geo> geo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Geo> getGeo() {
        return geo;
    }

    public void setGeo(List<Geo> geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", geo=" + geo +
                '}';
    }
}
