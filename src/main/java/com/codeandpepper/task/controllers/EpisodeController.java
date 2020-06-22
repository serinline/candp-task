package com.codeandpepper.task.controllers;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.models.CharacterEpisode;
import com.codeandpepper.task.models.Episode;
import com.codeandpepper.task.repositories.CharacterEpisodeRepository;
import com.codeandpepper.task.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class EpisodeController {

    @Autowired
    EpisodeRepository episodeRepository;

    @Autowired
    CharacterEpisodeRepository characterEpisodeRepository;

    @GetMapping(path="/episodes")
    public @ResponseBody Iterable<Episode> getAllEpisodes(){
        return episodeRepository.findAll();
    }

    @GetMapping(path="/episodes/{id}")
    public Optional<Episode> getEpisodeById(@PathVariable int id){
        return episodeRepository.findById(id);
    }

    @GetMapping(path="/episodes/characters/{id}")
    public Set<Character> getAllCharactersFromEpisode(@PathVariable int id){
        return characterEpisodeRepository.getAllByEpisode_Id(id)
                .stream()
                .map(CharacterEpisode::getCharacter)
                .collect(Collectors.toSet());
    }

    @PutMapping(path="/episodes/new")
    public Episode addEpisode(@PathVariable Episode episode){
        return episodeRepository.save(episode);
    }

}
