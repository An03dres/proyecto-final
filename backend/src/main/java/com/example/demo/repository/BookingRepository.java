package com.example.demo.repository;

import com.example.demo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository es una interfaz que proporciona métodos CRUD para la entidad Booking
@Repository
// JpaRepository<Booking, Long> indica que la entidad Booking es el modelo y Long es el tipo de datos de la clave primaria
public interface BookingRepository extends JpaRepository<Booking, Long> {
}