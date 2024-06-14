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
    @NotNull(message = "Artist is required.")
    private Long artist_id;
    @NotNull(message = "User is required.")
    private Long user_id;
    @NotNull(message = "Date is required.")
    private Date date;

    // Constructor sin argumentos
    public Booking() {
    }

    public Booking(Long artist_id, Long user_id, Date date) {
        this.artist_id = artist_id;
        this.user_id = user_id;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArtistId() {
        return artist_id;
    }

    public void setArtistId(Long artistId){
        this.artist_id = artistId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUserId() {
        return user_id;
    }

    public void setUserId(Long userId) {
        this.user_id = userId;
    }
}