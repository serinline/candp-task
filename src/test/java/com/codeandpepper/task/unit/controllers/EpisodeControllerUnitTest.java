package com.codeandpepper.task.unit.controllers;

import com.codeandpepper.task.models.Episode;
import com.codeandpepper.task.repositories.EpisodeRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EpisodeControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EpisodeRepository episodeRepository;

    private List<Episode> testEpisodes;

    @Before
    public void setUp(){
        Episode episode1 = new Episode(1010, "Title1");
        Episode episode2 = new Episode(2020, "Title2");
        testEpisodes = Arrays.asList(episode1, episode2);
    }

    @Test
    public void testGetEpisodes() throws Exception {
        when(episodeRepository.findAll()).thenReturn(testEpisodes);
        mockMvc.perform(get("/episodes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title1"))
                .andExpect(jsonPath("$[1].title").value("Title2"));
    }

    @Test
    public void testGetEpisodeById() throws Exception {
        when(episodeRepository.findById(1010)).thenReturn(Optional.of(testEpisodes.get(0)));
        mockMvc.perform(MockMvcRequestBuilders
                .get("/episodes/{id}", 1010)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1010));
    }

}
