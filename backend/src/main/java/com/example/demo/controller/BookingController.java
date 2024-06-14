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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {
    // Autowired inyecta una instancia de BookingRepository en esta clase
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    @PostMapping
    // RequestBody indica que el método espera un cuerpo de solicitud JSON
    public ResponseEntity<?> createBooking(@RequestBody Map<String, Object> payload) {
        try {
            Long artistId = Long.parseLong((String) payload.get("artist_id"));
            Long userId = Long.parseLong((String) payload.get("user_id"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse((String) payload.get("date"));
            Booking booking = new Booking(artistId, userId, date);
            Booking savedBooking = bookingRepository.save(booking);
            return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}