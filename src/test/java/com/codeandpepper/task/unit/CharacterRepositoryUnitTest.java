package com.codeandpepper.task.unit;

import com.codeandpepper.task.repositories.CharacterRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CharacterRepositoryUnitTest {

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

    @Test
    public void testGetOneCharacter(){
        Assert.assertNotNull(characterRepository.findById(2));
    }
}
