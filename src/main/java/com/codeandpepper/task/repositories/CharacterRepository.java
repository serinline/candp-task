package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterRepository extends CrudRepository<Character, Integer> {
    List<Character> findByName(String name);

}
