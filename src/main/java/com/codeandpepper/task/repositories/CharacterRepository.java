package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Integer> {
    void deleteCharacterByName(String name);
}
