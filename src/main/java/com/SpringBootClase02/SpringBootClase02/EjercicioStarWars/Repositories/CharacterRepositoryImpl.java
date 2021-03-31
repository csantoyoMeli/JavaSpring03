package com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Repositories;

import com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Dtos.CharacterDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    @Override
    public List<CharacterDTO> findCharactersByNameRepo(String name) {
        List<CharacterDTO> charactersFound = loadDatabase();
        for (Iterator<CharacterDTO> it = charactersFound.iterator(); it.hasNext();) {
            if (!it.next().getName().contains(name))
                it.remove();
        }
        return charactersFound;
    }

    private List<CharacterDTO> loadDatabase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeReference = new TypeReference<List<CharacterDTO>>() {
        };
        List<CharacterDTO> characters = null;

        try {
            characters = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return characters;

    }
}
