package com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlatoComidaDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
}
