package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "VARCHAR(1000)")
    private String bio;
    private String image;
    
    public Artist() {
    }

    public Artist(String name, String bio, String image) {
        this.name = name;
        this.bio = bio;
        this.image = image;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}