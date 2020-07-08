package com.codeandpepper.task.unit.controllers;

import com.codeandpepper.task.repositories.PlanetRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlanetControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanetRepository planetRepository;

    @Before
    public void setUp(){

    }
}
