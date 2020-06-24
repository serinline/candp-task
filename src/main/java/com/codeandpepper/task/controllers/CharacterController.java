package com.codeandpepper.task.controllers;

import com.codeandpepper.task.models.*;
import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private CharacterEpisodeRepository characterEpisodeRepository;

    @Autowired
    private FriendsRepository friendsRepository;

    @Autowired
    private PlanetRepository planetRepository;

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

    @GetMapping(path="/characters/episodes/{id}")
    public Set<Episode> getCharacterEpisodes(@PathVariable int id){
        return characterEpisodeRepository.getAllByCharacter_Id(id)
                .stream()
                .map(CharacterEpisode::getEpisode)
                .collect(Collectors.toSet());
    }

    @GetMapping(path="/characters/friends/{id}")
    public Set<Character> getCharacterFriends(@PathVariable int id){
        return friendsRepository.getAllByCharacter_Id(id)
                .stream()
                .map(Friends::getFriend)
                .collect(Collectors.toSet());
    }

    @GetMapping(path="/characters/planet/{id}")
    public Optional<Planet> getCharacterHomePlanet(@PathVariable int id){
        return planetRepository.findById(id);
    }

    @DeleteMapping(path="/characters/delete")
    public void deleteAllCharacters(){
        characterRepository.deleteAll();
    }

    @DeleteMapping(path="characters/delete/{id}")
    public void deleteCharacterById(@PathVariable int id){
        characterRepository.deleteById(id);
    }

    @DeleteMapping(path="characters/delete/{name}")
    public void deleteCharacterByName(@PathVariable String name){
        characterRepository.deleteCharacterByName(name);
    }

    @PutMapping(path="/characters/add")
    public Character addCharacter(@PathVariable Character character){
        return characterRepository.save(character);
    }
}
