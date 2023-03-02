package com.pwgolf.golfStats.controller;

import com.pwgolf.golfStats.model.impl.PlayedHole;
import com.pwgolf.golfStats.model.api.PlayedHoleRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@RestController
@RequestMapping("/api")
public class PlayedHoleController {
    private final Logger log = LoggerFactory.getLogger(com.pwgolf.golfStats.controller.PlayedHoleController.class);
    PlayedHoleRepository playedHoleRepository;

    @Autowired
    public PlayedHoleController(PlayedHoleRepository playedHoleRepository) {
        this.playedHoleRepository = playedHoleRepository;
    }

    @GetMapping("/playedHoles")
    Collection<PlayedHole> playedHoles() {
        return playedHoleRepository.findAll();
    }

    @GetMapping("/playedHoles/{id}")
    ResponseEntity<?> getPlayedHole(@PathVariable Long id) {
        Optional<PlayedHole> playedHole = playedHoleRepository.findById(id);
        return playedHole.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/playedHoles")
    ResponseEntity<PlayedHole> createPlayedHole(@Valid @RequestBody PlayedHole playedHole) throws URISyntaxException {
        log.info("Request to create PlayedHole: {}", playedHole);
        PlayedHole result = playedHoleRepository.save(playedHole);
        return ResponseEntity.created(new URI("/api/playedHole/" + result.getId()))
                .body(result);
    }

    @PutMapping("/playedHoles/{id}")
    ResponseEntity<PlayedHole> updatePlayedHole(@Valid @RequestBody PlayedHole playedHole) {
        log.info("Request to update PlayedHole: {}", playedHole);
        PlayedHole result = playedHoleRepository.save(playedHole);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/playedHoles/{id}")
    public ResponseEntity<?> deletePlayedHole(@PathVariable Long id) {
        log.info("Request to delete playedHole: {}", id);
        playedHoleRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/playedHoles/bulkImport")
    ResponseEntity<List<PlayedHole>> bulkImportPlayedHoles(@Valid @RequestBody List<PlayedHole> playedHoles) throws URISyntaxException {
        log.info("Request to create multiple hole records: {}", playedHoles);
        List<PlayedHole> results = new ArrayList<>();
        playedHoles.forEach(playedHole -> {
            PlayedHole result = playedHoleRepository.save(playedHole);
            results.add(result);
        });
        return ResponseEntity.ok().body(results);
    }
}
