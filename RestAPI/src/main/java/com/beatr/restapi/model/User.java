package com.beatr.restapi.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String zipcode;

    // constructor
    public User(int id, String name, String email, String zipcode) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.zipcode = zipcode;
    }
    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
