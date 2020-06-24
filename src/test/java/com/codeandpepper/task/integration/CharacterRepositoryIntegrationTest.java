package com.codeandpepper.task.integration;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.repositories.CharacterRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CharacterRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    CharacterRepository characterRepository;


    @Test
    public void findByIdThenReturnCharacter(){
        Character character = new Character(6, "C-3PO");
        entityManager.merge(character);
        entityManager.flush();
        Optional<Character> found = characterRepository.findById(6);
        assertThat(found.get().getName())
                .isEqualTo(character.getName());
    }
}
