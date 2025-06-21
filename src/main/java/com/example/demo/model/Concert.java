package com.example.demo.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Concert {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String location;
	    private String date;
	    private String time;
	    private int availableTickets;
	    private double ticketPrice;

	 // Getter and Setter for id
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    // Getter and Setter for name
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    // Getter and Setter for location
	    public String getLocation() {
	        return location;
	    }

	    public void setLocation(String location) {
	        this.location = location;
	    }

	    // Getter and Setter for date
	    public String getDate() {
	        return date;
	    }

	    public void setDate(String date) {
	        this.date = date;
	    }

	    // Getter and Setter for time
	    public String getTime() {
	        return time;
	    }

	    public void setTime(String time) {
	        this.time = time;
	    }

	    // Getter and Setter for availableTickets
	    public int getAvailableTickets() {
	        return availableTickets;
	    }

	    public void setAvailableTickets(int availableTickets) {
	        this.availableTickets = availableTickets;
	    }

	    // Getter and Setter for ticketPrice
	    public double getTicketPrice() {
	        return ticketPrice;
	    }

	    public void setTicketPrice(double ticketPrice) {
	        this.ticketPrice = ticketPrice;
	    }
}
