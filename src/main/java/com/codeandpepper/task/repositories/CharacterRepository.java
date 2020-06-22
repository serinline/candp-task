package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.Character;
import org.springframework.data.repository.CrudRepository;


public interface CharacterRepository extends CrudRepository<Character, Integer> {
    void deleteCharacterByName(String name);
}
