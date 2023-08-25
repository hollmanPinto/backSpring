package com.test.test.controllers;

import com.test.test.models.CapsulaCorreos;
import com.test.test.models.CapsulaFibonacci;
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
    @PostMapping(value = "/enviarSms")
    public ResponseEntity<?> enviarSms(@RequestHeader("user") String user, @RequestBody CapsulaCorreos entrada){
        if(!user.equals("admin")){
            return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body("Usuario no autorizado");
        }
        try{
            pruebaServices.enviarSms(entrada);
            return ResponseEntity.status(HttpStatus.OK.value()).body("Correos enviados correctamente");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("false");
        }
    }

    @PostMapping(value = "/fibonacci")
    public ResponseEntity<?> fibonacci(@RequestBody CapsulaFibonacci entrada){
        try{
            var sucesion = pruebaServices.sucesionFibonacci(entrada.getCantidad().intValue(),entrada.getSemilla());
            return ResponseEntity.status(HttpStatus.OK.value()).body(sucesion);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Ha ocurrido un error en fibonacci");
        }
    }
}
