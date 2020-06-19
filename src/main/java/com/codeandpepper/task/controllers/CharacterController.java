package com.codeandpepper.task.controllers;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping(path="/characters")
    public @ResponseBody Iterable<Character> getAllCharacters(){
        return characterRepository.findAll();
    }
}
