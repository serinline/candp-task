package com.codeandpepper.task.unit;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.repositories.CharacterRepository;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CharacterRepositoryUnitTest {

    @Autowired
    CharacterRepository characterRepository;

    @MockBean
    private RestTemplate template;


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
    public void testGetCharacterById(){
        String json ="{\"id\":2, \"name\":\"Darth Vader\", \"homePlanet\":null}";

        Character expected = new Gson().fromJson(json, Character.class);
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));
        Character result = characterRepository.findById(2).get();
        assertThat(result)
                .isNotNull()
                .matches(p -> p.getName().equals("Darth Vader"));
    }
}
