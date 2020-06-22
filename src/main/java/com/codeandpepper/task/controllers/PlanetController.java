package com.codeandpepper.task.controllers;

import com.codeandpepper.task.models.Planet;
import com.codeandpepper.task.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PlanetController {

    @Autowired
    PlanetRepository planetRepository;

    @GetMapping(path="/planets")
    public @ResponseBody Iterable<Planet> getAllPlanets(){
        return planetRepository.findAll();
    }

    @GetMapping(path="planets/{id}")
    public @ResponseBody Optional<Planet> getPlanetById(@PathVariable int id){
        return planetRepository.findById(id);
    }
}
