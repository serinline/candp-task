package com.codeandpepper.task.unit;

import com.codeandpepper.task.models.Planet;
import com.codeandpepper.task.repositories.PlanetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class PlanetRepositoryUnitTest {

    @MockBean
    PlanetRepository planetRepository;


    @Test
    public void testGetPlanetById(){
        Planet expected = new Planet(1, "Alderaan");
        when(planetRepository.findById(anyInt())).thenReturn(java.util.Optional.of(expected));
        Planet result = planetRepository.findById(1).get();
        assertThat(result)
                .isNotNull()
                .matches(p -> p.getName()
                        .equals("Alderaan"));
    }
}
