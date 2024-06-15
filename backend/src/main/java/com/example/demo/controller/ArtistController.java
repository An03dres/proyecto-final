package com.example.demo.controller;

import com.example.demo.model.Artist;
import com.example.demo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
@CrossOrigin(origins = "*")  // CORS (Cross-Origin Resource Sharing) is a mechanism that uses additional HTTP headers to tell browsers to give a web application running at one origin, access to selected resources from a different origin.
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/all")
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
    // Ejemplo de un método para obtener un artista por ID
    // www.example.com/api/artists/1
    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) throws Exception {
        return artistRepository.findById(id)
                .orElseThrow(() -> new Exception("Artist not found"));
    }
}