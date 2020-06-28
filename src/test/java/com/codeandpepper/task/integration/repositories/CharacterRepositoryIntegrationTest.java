package com.codeandpepper.task.integration.repositories;

import com.codeandpepper.task.repositories.CharacterRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CharacterRepositoryIntegrationTest {

    @Autowired
    CharacterRepository characterRepository;


    @Test
    public void testIfCharacterExists(){
        Assert.assertTrue(characterRepository.existsById(3));
        Assert.assertFalse(characterRepository.existsById(200));
    }

    @Test
    public void testGetCharacters(){
        Assert.assertNotNull(characterRepository.findAll());
    }
}
