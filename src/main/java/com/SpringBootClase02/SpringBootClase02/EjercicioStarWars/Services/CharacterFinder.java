package com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Services;

import com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Dtos.CharacterDTO;

import java.util.List;

public interface CharacterFinder {
    public List<CharacterDTO> findCharactersByName(String name);
}
