package com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto;

import lombok.Data;

import java.util.List;

@Data
public class CalculosResponseDTO {
    private int caloriasTotales;
    private List<IngredienteResponseDTO> caloriasIngrediente;
    private IngredienteResponseDTO ingredienteMayor;
}
