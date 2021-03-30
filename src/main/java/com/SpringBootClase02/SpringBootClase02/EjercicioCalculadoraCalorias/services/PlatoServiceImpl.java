package com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.services;

import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.CalculosResponseDTO;
import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.IngredienteDTO;
import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.IngredienteResponseDTO;
import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.PlatoComidaDTO;
import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.repositories.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoServiceImpl implements PlatoService {
    private final IngredienteRepository ingredienteRepository;

    public PlatoServiceImpl(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public int calcularCalorias(PlatoComidaDTO plato) {
        int totalCalorias = 0;
        for (IngredienteDTO ingrediente : plato.getIngredientes()) {
            IngredienteResponseDTO ingredienteDTO = ingredienteRepository.findCaloriesByName(ingrediente.getNombre());
            totalCalorias += ingredienteDTO.getCalories() * ingrediente.getPeso();
        }
        return totalCalorias;
    }

    public List<IngredienteResponseDTO> obtenerIngredientes(PlatoComidaDTO plato) {
        List<IngredienteResponseDTO> ingredientes = new ArrayList<>();
        for (IngredienteDTO ingrediente : plato.getIngredientes()) {
            IngredienteResponseDTO responseDTO = ingredienteRepository.findCaloriesByName(ingrediente.getNombre());
            responseDTO.setCalories(responseDTO.getCalories() * ingrediente.getPeso());
            ingredientes.add(responseDTO);
        }
        return ingredientes;
    }

    public IngredienteResponseDTO obtenerIngredienteMayor(List<IngredienteResponseDTO> ingredienteDTOS) {
        int max = 0;
        IngredienteResponseDTO ingredienteMayor = null;
        for (IngredienteResponseDTO ingrediente : ingredienteDTOS) {
            if (ingrediente.getCalories() > max) {
                max = ingrediente.getCalories();
                ingredienteMayor = ingrediente;
            }
        }
        return ingredienteMayor;
    }

    @Override
    public CalculosResponseDTO calcularTotalCalorias(PlatoComidaDTO plato) {
        CalculosResponseDTO calculos = new CalculosResponseDTO();
        calculos.setCaloriasTotales(this.calcularCalorias(plato));
        List<IngredienteResponseDTO> listaIngredientes = this.obtenerIngredientes(plato);
        calculos.setCaloriasIngrediente(listaIngredientes);
        calculos.setIngredienteMayor(obtenerIngredienteMayor(listaIngredientes));

        return calculos;
    }

    @Override
    public List<CalculosResponseDTO> procesarComida(List<PlatoComidaDTO> platos) {
        List<CalculosResponseDTO> platosProcesados = new ArrayList<>();
        for (PlatoComidaDTO plato : platos) {
            platosProcesados.add(this.calcularTotalCalorias(plato));
        }
        return platosProcesados;
    }

}
