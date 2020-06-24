package com.codeandpepper.task.unit;

import com.codeandpepper.task.models.Planet;
import com.codeandpepper.task.repositories.PlanetRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class PlanetRepositoryUnitTest {

    @Autowired
    PlanetRepository planetRepository;

    @MockBean
    private RestTemplate template;

    @Test
    public void testGetPlanetById(){
        Planet expected = new Planet(1, "Alderaan");
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));
        Planet result = planetRepository.findById(1).get();
        assertThat(result)
                .isNotNull()
                .matches(p -> p.getName()
                        .equals("Alderaan"));
    }
}
