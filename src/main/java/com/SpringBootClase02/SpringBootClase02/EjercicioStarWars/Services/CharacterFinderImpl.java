package com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Services;

import com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Dtos.CharacterDTO;
import com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterFinderImpl implements CharacterFinder {
    private final CharacterRepository characterRepository;

    public CharacterFinderImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterDTO> findCharactersByName(String name) {
        return characterRepository.findCharactersByNameRepo(name);
    }
}
