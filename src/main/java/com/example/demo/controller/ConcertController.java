package com.example.demo.controller;

import com.example.demo.model.Concert;
import com.example.demo.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/concerts")
public class ConcertController {
    @Autowired
    private ConcertService concertService;

    @GetMapping
    public List<Concert> getAllConcerts() {
        return concertService.getAllConcerts();
    }

    @GetMapping("/{id}")
    public Concert getConcertById(@PathVariable Long id) {
        return concertService.getConcertById(id).orElseThrow(() -> new RuntimeException("Concert not found"));
    }

    @PostMapping
    public Concert createConcert(@RequestBody Concert concert) {
        return concertService.saveConcert(concert);
    }

    @PutMapping("/{id}")
    public Concert updateConcert(@PathVariable Long id, @RequestBody Concert concert) {
        concert.setId(id);
        return concertService.saveConcert(concert);
    }

    @DeleteMapping("/{id}")
    public void deleteConcert(@PathVariable Long id) {
        concertService.deleteConcert(id);
    }
}
