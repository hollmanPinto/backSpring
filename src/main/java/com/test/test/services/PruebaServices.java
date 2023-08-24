package com.test.test.services;

import com.test.test.models.Prueba;
import com.test.test.repositories.RepoMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class PruebaServices {
    @Autowired
    @Lazy
    RepoMain repoMain;
    public void prueba(){
        try{
            Prueba prueba = new Prueba();
            prueba.setId(1L);
            prueba.setValor("Hollman");
            repoMain.save(prueba);
            System.out.println("Se guarda correctamente");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Prueba obtener(Long id){
        return repoMain.findById(id).get();
    }
    public Long guardar(Prueba body){
        return repoMain.save(body).getId();
    }
}
