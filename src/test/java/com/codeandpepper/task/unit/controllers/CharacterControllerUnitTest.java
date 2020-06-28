package com.codeandpepper.task.unit.controllers;

import com.codeandpepper.task.StarwarsApplication;
import com.codeandpepper.task.controllers.CharacterController;
import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.models.Friends;
import com.codeandpepper.task.repositories.CharacterEpisodeRepository;
import com.codeandpepper.task.repositories.CharacterRepository;
import com.codeandpepper.task.repositories.FriendsRepository;
import com.codeandpepper.task.repositories.PlanetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private CharacterController characterController;

    @MockBean
    private CharacterRepository characterRepository;

    private List<Character> testCharacters;

    @Before
    public void setUp(){
        Character character1 = new Character(111, "Test Character 1");
        Character character2 = new Character(222, "Test Character 2");
        testCharacters = Arrays.asList(character1, character2);
    }

    @Test
    public void testGetAllCharacters() throws Exception {
        when(characterRepository.findAll()).thenReturn(testCharacters);
        mockMvc.perform(get("/characters")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test Character 1"))
                .andExpect(jsonPath("$[1].name").value("Test Character 2"));
    }
}
