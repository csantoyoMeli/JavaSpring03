package com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.SpringBootClase02.SpringBootClase02.EjercicioCalculadoraCalorias.dto.IngredienteResponseDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepositoryImpl implements IngredienteRepository{
    @Override
    public IngredienteResponseDTO findCaloriesByName(String name) {
        List<IngredienteResponseDTO> ingredientesDTOS = null;
        ingredientesDTOS = loadDataBase();
        IngredienteResponseDTO result = null;
        if (ingredientesDTOS != null){
            Optional<IngredienteResponseDTO> item = ingredientesDTOS.stream()
                        .filter(ingredienteResponseDTO -> ingredienteResponseDTO.getName().equals(name))
                        .findFirst();
            if (item.isPresent())
                result = item.get();
        }
        return result;
    }

    private List<IngredienteResponseDTO> loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteResponseDTO>> typeReference = new TypeReference<List<IngredienteResponseDTO>>() {};
        List<IngredienteResponseDTO> ingredients = null;

        try {
            ingredients = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ingredients;
    }
}
