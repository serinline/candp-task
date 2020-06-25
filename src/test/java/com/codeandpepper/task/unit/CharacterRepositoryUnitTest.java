package com.codeandpepper.task.unit;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.repositories.CharacterRepository;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CharacterRepositoryUnitTest {

    @MockBean
    private CharacterRepository characterRepository;


    @Test
    public void testGetCharacterById(){
        String json ="{\"id\":2, \"name\":\"Darth Vader\", \"homePlanet\":null}";

        Character expected = new Gson().fromJson(json, Character.class);
        Character result = characterRepository.findById(2).get();
        when(characterRepository.findById(anyInt())).thenReturn(java.util.Optional.ofNullable(expected));
        assertThat(result.getName())
                .isNotNull()
                .isEqualTo(expected.getName());
    }

    @Test
    public void testAddNewCharacter(){
        Character newCharacter = characterRepository.save(new Character(1, "Test Character"));
        when(characterRepository.save(any(Character.class))).thenReturn(newCharacter);
        assertThat(newCharacter).hasFieldOrPropertyWithValue("name", "Test Character");
    }

    @Test
    public void testDeleteCharacter(){
        //TODO
    }

}
