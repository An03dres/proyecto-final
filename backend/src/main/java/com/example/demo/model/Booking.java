package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

// Entity es una clase que se mapea a una tabla en la base de datos
@Entity
public class Booking {

    // Id es la clave primaria de la tabla
    @Id
    // GeneratedValue indica que el valor de la clave primaria se generará automáticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ManyToOne indica que la relación entre Booking y Artist es de muchos a uno
    @ManyToOne
    @JoinColumn(name = "artist_id")
    @NotNull(message = "Artist is required.")
    private Artist artist;

    @NotNull(message = "Date is required.")
    private Date date;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}