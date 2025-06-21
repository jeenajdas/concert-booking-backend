package com.example.demo.repository;

import com.example.demo.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Custom query method to fetch bookings by user ID
    List<Booking> findAllByUserId(Long userId);
}
