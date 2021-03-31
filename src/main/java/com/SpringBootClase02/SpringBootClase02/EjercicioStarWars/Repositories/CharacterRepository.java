package com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Repositories;

import com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Dtos.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
    public List<CharacterDTO> findCharactersByNameRepo(String name);
}
