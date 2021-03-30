package com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.controller;

import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.services.PlatoService;
import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.PlatoComidaDTO;
import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.PlatosProcesadosDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calorias")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @PostMapping("/obtenerCalorias")
    public ResponseEntity obtenerCalorias(@RequestBody PlatoComidaDTO plato){
        return new ResponseEntity(platoService.calcularTotalCalorias(plato), HttpStatus.OK);
    }

    @PostMapping("/listadoPlatos")
    public ResponseEntity obtenerListado(@RequestBody PlatosProcesadosDTO platos){
        return new ResponseEntity(platoService.procesarComida(platos.getPlatos()), HttpStatus.OK);
    }

}
