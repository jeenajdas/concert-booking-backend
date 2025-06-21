package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.model.Concert;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.ConcertRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ConcertRepository concertRepository;

    /**
     * Book tickets for a concert.
     *
     * @param concertId ID of the concert
     * @param tickets   Number of tickets to book
     * @param userId    ID of the user booking the tickets
     * @param username  Username of the user
     * @return Result message indicating success or failure
     */
    @Transactional
    public String bookTickets(Long concertId, int tickets, Long userId, String username) {
        if (tickets > 3) {
            return "Error: You can only book up to 3 tickets.";
        }

        Concert concert = concertRepository.findById(concertId)
                .orElseThrow(() -> new RuntimeException("Error: Concert not found."));

        if (concert.getAvailableTickets() >= tickets) {
            // Update concert's available tickets
            concert.setAvailableTickets(concert.getAvailableTickets() - tickets);
            concertRepository.save(concert);

            // Create and save booking
            Booking booking = new Booking();
            booking.setConcert(concert);
            booking.setTicketsBooked(tickets);
            booking.setUserId(userId);
            booking.setUsername(username);
            booking.setTotalPrice(tickets * concert.getTicketPrice()); // Calculate total price
            booking.setBookingDate(LocalDateTime.now()); // Set the booking date
            bookingRepository.save(booking);

            return "Tickets booked successfully!";
        } else {
            return "Error: Not enough tickets available.";
        }
    }

    /**
     * Fetch details of a concert by its ID.
     *
     * @param concertId ID of the concert
     * @return Concert details or null if not found
     */
    public Concert getConcertDetails(Long concertId) {
        return concertRepository.findById(concertId).orElse(null);
    }

    /**
     * Fetch all bookings for a specific user.
     *
     * @param userId ID of the user
     * @return List of bookings for the user
     */
    public List<Booking> getUserBookings(Long userId) {
        return bookingRepository.findAllByUserId(userId);
    }

    /**
     * Fetch all bookings (Admin use).
     *
     * @return List of all bookings
     */
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
