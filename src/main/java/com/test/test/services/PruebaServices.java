package com.test.test.services;

import com.test.test.models.CapsulaCorreos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PruebaServices {
    @Autowired
    JavaMailSender javaMailSender;

    /**
     * Este método no recibe parametros y envia un correo a cada destino que aparece
     * en el array de Strings correos, el correo contiene la sucesion de fibonacci
     * se utiliza la dependencia spring-boot-starter-mail, para el envio.
     */
    public void enviarSms(CapsulaCorreos entrada){
        try{
            List<String> correos = new ArrayList<>();
            correos.add("didier.correa@proteccion.com.co");
            correos.add("correalondon@gmail.com");
            if(entrada.getCorreo1()!=null && entrada.getCorreo2()!=null){
                List<String> correosList = new ArrayList<>();
                correosList.add(entrada.getCorreo1());
                correosList.add(entrada.getCorreo2());
                correos.clear();
                correos=correosList;
            }
            //obtener fecha sistema
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date fechaActual = new Date();
            String horaGen = sdf.format(fechaActual);
            int seconds = fechaActual.getSeconds();
            String minutesS = fechaActual.getMinutes()<10?"0"+fechaActual.getMinutes():""+fechaActual.getMinutes();
            System.out.println("LOGS: Hora generacion- "+horaGen);
            var fibonacci = sucesionFibonacci(seconds,minutesS);
            //envio de correos
            StringBuilder sb = new StringBuilder();
            sb.append("Hora exacta de generación: "+horaGen+"\n\n");
            sb.append("Sucesión de Fibonacci: \n\n"+fibonacci);
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("Sucesion Fibonacci");
            simpleMailMessage.setText(sb.toString());
            simpleMailMessage.setFrom("holeo.pintozapata@gmail.com");
            for(String c:correos){
                simpleMailMessage.setTo(c);
                javaMailSender.send(simpleMailMessage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * este metodo genera una sucesion de fibonacci de acuerdo a una semilla y
     * cantidad que se le pida
     * @return lista de longs. sucesion de fibonacci
     */
    public List<Long> sucesionFibonacci(int cantidad, String semilla){
        int[] intTab = semilla.chars().map(Character::getNumericValue).toArray();
        long x=intTab[0];
        long y=intTab[1];
        long tmp=0;
        List<Long> sucesion = new ArrayList<>();
        sucesion.add(x);
        sucesion.add(y);
        for(int i=0; i<=cantidad-1 ;i++){//le resto 2 al for porque ya ocupe 2 espacios arriba
            tmp = sucesion.get(i)+sucesion.get(i+1);
            sucesion.add(tmp);
        }
        sucesion.sort(Collections.reverseOrder());
        return sucesion;
    }
}
