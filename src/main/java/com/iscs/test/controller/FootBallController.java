package com.iscs.test.controller;

import com.iscs.test.model.Team;
import com.iscs.test.service.FootBallService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Fassil on 17/11/20.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class FootBallController {
    final FootBallService footBallService;

    public FootBallController(FootBallService footBallService) {
        this.footBallService = footBallService;
    }

    @GetMapping(value = "/v1/football/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllFootBallData() throws IOException {
        String[][] range = footBallService.getAllFootBallData();
        return ResponseEntity.ok().body(range);
    }

    @GetMapping(value = "/v1/football", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSmallestRange() throws IOException {
        Team picollaDifferenza = footBallService.getSmallestGoalDifference();
        return ResponseEntity.ok().body(picollaDifferenza);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
