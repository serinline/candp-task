package com.codeandpepper.task.integration;

import com.codeandpepper.task.models.Episode;
import com.codeandpepper.task.repositories.EpisodeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EpisodeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Test
    public void findByIdThenReturnEpisode(){
        Episode episode = new Episode(1, "NEWHOPE");
        entityManager.merge(episode);
        entityManager.flush();
        Optional<Episode> found = episodeRepository.findById(1);
        assertThat(found.get().getTitle())
                .isEqualTo(episode.getTitle());
    }


}
