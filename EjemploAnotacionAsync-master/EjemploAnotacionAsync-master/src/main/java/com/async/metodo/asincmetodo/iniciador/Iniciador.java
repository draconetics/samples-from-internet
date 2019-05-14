/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.async.metodo.asincmetodo.iniciador;

import com.async.metodo.asincmetodo.modelo.Paciente;
import com.async.metodo.asincmetodo.servicio.ServicioAtencion;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author ProgramacionColombia
 */
@Component
public class Iniciador implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(Iniciador.class);

    @Autowired
    private ServicioAtencion servicioAtencion;

    @Override
    public void run(String... args) throws Exception {
        CompletableFuture<String> atencion1 = servicioAtencion
                .atender(new Paciente("Juan", "Gripa"));
        CompletableFuture<String> atencion2 = servicioAtencion
                .atender(new Paciente("Miguel", "Dolor de cabeza"));
        CompletableFuture<String> atencion3 = servicioAtencion
                .atender(new Paciente("Marta", "Alergía"));
        CompletableFuture<String> atencion4 = servicioAtencion
                .atender(new Paciente("Camila", "Mareos"));

        CompletableFuture.allOf(atencion1, atencion2, atencion3, atencion4).join();

        logger.info("Mostrando estadísticas");

        logger.info(atencion1.get());
        logger.info(atencion2.get());
        logger.info(atencion3.get());
        logger.info(atencion4.get());
    }

}
