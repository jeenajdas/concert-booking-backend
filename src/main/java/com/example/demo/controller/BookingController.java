package com.example.demo.controller;

import com.example.demo.dto.BookingRequest;
import com.example.demo.model.Booking;
import com.example.demo.model.Concert;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * Endpoint to book tickets for a concert.
     * @param concertId ID of the concert
     * @param tickets Number of tickets to book
     * @param userId ID of the user
     * @param username Username of the user
     * @return Response message
     */
    @PostMapping("/book")
    public ResponseEntity<String> bookTickets(@RequestBody BookingRequest bookingRequest) {
        String result = bookingService.bookTickets(
                bookingRequest.getConcertId(),
                bookingRequest.getTickets(),
                bookingRequest.getUserId(),
                bookingRequest.getUsername()
        );
        return ResponseEntity.ok(result);
    }


    /**
     * Endpoint to fetch details of a concert.
     * @param concertId ID of the concert
     * @return Concert details
     */
    @GetMapping("/concert/{id}")
    public ResponseEntity<Concert> getConcertDetails(@PathVariable("id") Long concertId) {
        Concert concert = bookingService.getConcertDetails(concertId);
        if (concert != null) {
            return ResponseEntity.ok(concert);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint to fetch all bookings for a specific user.
     * @param userId ID of the user
     * @return List of bookings for the user
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getUserBookings(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.getUserBookings(userId);
        return ResponseEntity.ok(bookings);
    }

    /**
     * Endpoint to fetch all bookings (Admin use).
     * @return List of all bookings
     */
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
