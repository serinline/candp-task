package com.codeandpepper.task.controllers;

import com.codeandpepper.task.models.Episode;
import com.codeandpepper.task.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EpisodeController {

    @Autowired
    EpisodeRepository episodeRepository;

    @GetMapping(path="/episodes")
    public @ResponseBody Iterable<Episode> getAllEpisodes(){
        return episodeRepository.findAll();
    }
}
