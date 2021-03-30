package com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.repositories;

import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.IngredienteResponseDTO;

public interface IngredienteRepository {
    public IngredienteResponseDTO findCaloriesByName(String name);
}
