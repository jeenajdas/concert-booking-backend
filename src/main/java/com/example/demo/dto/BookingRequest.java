package com.example.demo.dto;

public class BookingRequest {
	private Long concertId;
    private int tickets;
    private Long userId;
    private String username;

    // Default constructor (if needed)
    public BookingRequest() {}

    // Getters and setters
    public Long getConcertId() {
        return concertId;
    }

    public void setConcertId(Long concertId) {
        this.concertId = concertId;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
