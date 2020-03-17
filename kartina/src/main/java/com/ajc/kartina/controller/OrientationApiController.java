package com.ajc.kartina.controller;

import com.ajc.kartina.model.Orientation;
import com.ajc.kartina.repository.OrientationRepository;
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
public class OrientationApiController {

    @Autowired
    private OrientationRepository repository;

    @GetMapping("/orientations")
    public ResponseEntity<List<Orientation>> list() {
        return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
    }
}
