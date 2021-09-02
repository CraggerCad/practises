package com.progressive.htmlescape.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JasperPractise {

    @GetMapping("/getReport")
    public ResponseEntity<?> asd(){
        return new ResponseEntity<>("asd", HttpStatus.OK);
    }
}
