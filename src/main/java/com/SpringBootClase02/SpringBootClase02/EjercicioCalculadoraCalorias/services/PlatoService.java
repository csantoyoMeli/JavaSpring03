package com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.services;

import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.CalculosResponseDTO;
import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.PlatoComidaDTO;

import java.util.List;

public interface PlatoService {
    public CalculosResponseDTO calcularTotalCalorias(PlatoComidaDTO plato);
    public List<CalculosResponseDTO> procesarComida(List<PlatoComidaDTO> platos);
}
