package com.test.controllers;

import com.test.services.PruebaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/test")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PruebaController {
    @Autowired
    PruebaServices pruebaServices;

    @GetMapping(value = "/inicial")
    public ResponseEntity<?> inicial(){
        pruebaServices.prueba();
        return null;
    }//pruebaConsulta21
}
