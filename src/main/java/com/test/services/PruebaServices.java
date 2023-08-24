package com.test.services;

import com.test.models.Prueba;
import com.test.repositories.PruebaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruebaServices {
    @Autowired
    PruebaRepo pruebaRepo;
    public void prueba(){
        try{
            Prueba prueba = new Prueba();
            prueba.setId(1L);
            prueba.setValor("Hollman");
            pruebaRepo.save(prueba);
            System.out.println("Se guarda correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
