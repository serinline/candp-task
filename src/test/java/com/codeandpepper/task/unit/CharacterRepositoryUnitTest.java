package com.codeandpepper.task.unit;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.repositories.CharacterRepository;
import com.google.gson.Gson;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CharacterRepositoryUnitTest {

    private static CharacterRepository characterRepository;

    @BeforeClass
    public static void setUp() {
        characterRepository = mock(CharacterRepository.class);

        Character character1 = new Character(111, "Test Character 1");
        Character character2 = new Character(222, "Test Character 2");

        when(characterRepository.count()).thenReturn((long) Arrays.asList(character1, character2).size());
        when(characterRepository.findAll()).thenReturn(Arrays.asList(character1, character2));
        when(characterRepository.findById(111)).thenReturn(java.util.Optional.of(character1));
        doAnswer(x -> null).when(characterRepository).deleteAll();
    }

    @Test
    public void testGetNumberOfCharacters(){
        long characters = characterRepository.count();
        assertNotNull(characters);
        assertEquals(2, characters);
    }

    @Test
    public void testGetAllCharacters(){
        Iterable<Character> result = characterRepository.findAll();
        assertThat(StreamSupport.stream(result.spliterator(), false)
                .anyMatch(p -> p.getName().equals("Test Character 1")));
        assertThat(StreamSupport.stream(result.spliterator(), false)
                .anyMatch(p -> p.getName().equals("Test Character 2")));
    }

    @Test
    public void testGetCharacterById(){
        String json ="{\"id\":2, \"name\":\"Test Character 1\", \"homePlanet\":null}";
        Character expected = new Gson().fromJson(json, Character.class);
        Character result = characterRepository.findById(111).get();
        assertThat(result.getName())
                .isNotNull()
                .isEqualTo(expected.getName());
    }

    @Test
    public void testAddNewCharacter(){
        Character newCharacter = new Character(1, "Test Character");
        when(characterRepository.save(any(Character.class))).thenReturn(newCharacter);
        Character result = characterRepository.save(newCharacter);
        assertThat(result).hasFieldOrPropertyWithValue("name", "Test Character");
    }

    @Test
    public void testDeleteAll(){
        characterRepository.deleteAll();
        verify(characterRepository, times(1)).deleteAll();
    }

}
