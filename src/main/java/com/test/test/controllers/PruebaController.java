package com.test.test.controllers;

import com.test.test.models.Prueba;
import com.test.test.services.PruebaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/obtener")
    public ResponseEntity<?> obtener(@RequestParam Long id){
        try{
            var res = pruebaServices.obtener(id);
            return ResponseEntity.status(HttpStatus.OK.value()).body(res);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Error obteniendo por id: "+id);
        }
    }
    @PostMapping(value = "/guardar")
    public ResponseEntity<?> guardar(@RequestBody Prueba body){
        try{
            var res = pruebaServices.guardar(body);
            return ResponseEntity.status(HttpStatus.OK.value()).body(res);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Error guardando");
        }
    }
}
