package com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Controllers;

import com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Dtos.CharacterDTO;
import com.SpringBootClase02.SpringBootClase02.EjercicioStarWars.Services.CharacterFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("character")
public class CharacterController {

    @Autowired
    private CharacterFinder characterFinder;

    @GetMapping("/findByName/{name}")
    public ResponseEntity<CharacterDTO> getCharacters(@PathVariable String name){
        return new ResponseEntity(characterFinder.findCharactersByName(name), HttpStatus.OK);
    }
}
