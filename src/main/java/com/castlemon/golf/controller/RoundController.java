package com.castlemon.golf.controller;

import com.castlemon.golf.entity.Round;
import com.castlemon.golf.exception.RoundNotFoundException;
import com.castlemon.golf.repository.RoundRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class RoundController {

    private final RoundRepository repository;

    RoundController(RoundRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin()
    @GetMapping("/rounds")
    List<Round> all() {
        return repository.findAll();
    }

    @CrossOrigin()
    @PostMapping("/rounds")
    Round newRound(@RequestBody Round newRound) {
        return repository.save(newRound);
    }

    // Single item

    @GetMapping("/Rounds/{id}")
    Round one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new RoundNotFoundException(id));
    }

    @PutMapping("/Rounds/{id}")
    Round replaceRound(@RequestBody Round newRound, @PathVariable Integer id) {

        return repository.findById(id)
                .map(Round -> {
                    Round.setCourseName(newRound.getCourseName());
                    Round.setDate(newRound.getDate());
                    return repository.save(Round);
                })
                .orElseGet(() -> {
                    return repository.save(newRound);
                });
    }

    @DeleteMapping("/Rounds/{id}")
    void deleteRound(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
