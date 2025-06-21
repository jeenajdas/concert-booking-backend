package com.example.demo.service;

import com.example.demo.model.Concert;
import com.example.demo.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    // Get all concerts (Read operation)
    public List<Concert> getAllConcerts() {
        return concertRepository.findAll();
    }

    // Get a concert by ID (Read operation)
    public Optional<Concert> getConcertById(Long id) {
        return concertRepository.findById(id);
    }

    // Save or update a concert (Create/Update operation)
    public Concert saveConcert(Concert concert) {
        return concertRepository.save(concert);
    }

    // Delete a concert by ID (Delete operation)
    public void deleteConcert(Long id) {
        concertRepository.deleteById(id);
    }
}
