package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody Map<String, Object> payload) {
        try {
            String name = (String) payload.get("name");
            String email = (String) payload.get("email");
            String password = (String) payload.get("password");
            String phoneNumber = (String) payload.get("phone_number");

            userRepository.findByEmail(email).ifPresent(user -> {
                throw new RuntimeException("Email already exists");
            });

            User user = new User(name, email, password, phoneNumber);
            User savedUser = userRepository.save(user);

            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody Map<String, Object> payload) {
        try {
            // recoger el email y la contraseña del payload
            String email = (String) payload.get("email");
            String password = (String) payload.get("password");
            // buscar el usuario por email en nuestra base de datos
            User user = (User) userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            // comprobar si la contraseña del usuario coincide con la contraseña del payload
            if (!user.getPassword().equals(password)) {
                throw new RuntimeException("Invalid password");
            }
            // devolver el usuario
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

