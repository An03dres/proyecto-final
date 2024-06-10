package com.example.demo.controller;

import com.example.demo.model.Artist;
import com.example.demo.model.Booking;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.BookingRepository;
import net.bytebuddy.asm.MemberSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// RestController indica que esta clase manejará las solicitudes HTTP
@RestController
// RequestMapping especifica la URL base para todas las solicitudes en esta clase
@RequestMapping("/api/bookings")
// CrossOrigin permite solicitudes desde cualquier origen
// CORS (Cross-Origin Resource Sharing) es un mecanismo que utiliza cabeceras HTTP adicionales para permitir que un user agent obtenga permiso para acceder a recursos seleccionados desde un servidor, en un origen distinto (dominio) al que pertenece
@CrossOrigin(origins = "*")
public class BookingController {

    // Autowired inyecta una instancia de BookingRepository en esta clase
    @Autowired
    private BookingRepository bookingRepository;

    // Autowired inyecta una instancia de ArtistRepository en esta clase
    @Autowired
    private ArtistRepository artistRepository;

    // PostMapping indica que este método manejará las solicitudes POST
    @PostMapping
    // RequestBody indica que el método espera un cuerpo de solicitud JSON
    public ResponseEntity<?> createBooking(@RequestBody Map<String, Object> payload) {
        try {
            // Se obtiene el ID del artista y la fecha de la solicitud
            Long artistId = Long.parseLong((String) payload.get("artist_id"));
            // Se convierte la fecha de la solicitud en un objeto Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Se convierte la fecha de la solicitud en un objeto Date
            Date date = dateFormat.parse((String) payload.get("date"));
            // Se busca el artista por ID
            Artist artist = artistRepository.findById(artistId)
                    // Si el artista no se encuentra, se lanza una excepción ERROR
                    .orElseThrow(() -> new Exception("Artist not found"));

            // Se crea una nueva instancia de Booking
            Booking booking = new Booking();
            // Se establece el artista y la fecha de la solicitud
            booking.setArtist(artist);
            booking.setDate(date);
            // Se guarda la solicitud en la base de datos
            Booking savedBooking = bookingRepository.save(booking);
            // Se actualiza la lista de solicitudes del artista
//            artist.addBooking(savedBooking);

            // Se devuelve la solicitud guardada con el código de estado HTTP 201
            return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(createErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Map<String, String> createErrorResponse(String message) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", message);
        return errorResponse;
    }
}