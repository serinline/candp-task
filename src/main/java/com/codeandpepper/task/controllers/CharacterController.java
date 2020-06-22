package com.codeandpepper.task.controllers;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping(path="/characters")
    public @ResponseBody Iterable<Character> getAllCharacters(){
        return characterRepository.findAll();
    }

    @GetMapping(path="/characters/count")
    public @ResponseBody long getNumberOfCharacters() {
        return characterRepository.count();
    }

    @GetMapping(path="characters/exists/{id}")
    public @ResponseBody boolean doesCharacterExists(@PathVariable int id){
        return characterRepository.existsById(id);
    }

    @GetMapping("/characters/{id}")
    public Optional<Character> oneCharacter(@PathVariable int id) {
        return characterRepository.findById(id);
    }

    @DeleteMapping("/characters/delete")
    public void deleteAllCharacters(){
        characterRepository.deleteAll();
    }

    @DeleteMapping("characters/delete/{id}")
    public void deleteCharacterById(@PathVariable int id){
        characterRepository.deleteById(id);
    }

    @DeleteMapping("characters/delete/{name}")
    public void deleteCharacterByName(@PathVariable String name){
        characterRepository.deleteCharacterByName(name);
    }

    @PutMapping("/characters/add")
    public Character addCharacter(@PathVariable Character character){
        return characterRepository.save(character);
    }
}
