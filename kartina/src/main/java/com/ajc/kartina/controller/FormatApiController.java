package com.ajc.kartina.controller;

import com.ajc.kartina.model.Format;
import com.ajc.kartina.repository.FormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FormatApiController {

    @Autowired
    private FormatRepository repository;

    @GetMapping("/formats")
    public ResponseEntity<List<Format>> list() {
        return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
    }
}
