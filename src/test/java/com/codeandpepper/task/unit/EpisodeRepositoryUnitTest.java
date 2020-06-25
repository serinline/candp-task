package com.codeandpepper.task.unit;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.models.CharacterEpisode;
import com.codeandpepper.task.models.Episode;
import com.codeandpepper.task.repositories.CharacterEpisodeRepository;
import com.codeandpepper.task.repositories.EpisodeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class EpisodeRepositoryUnitTest {

    @MockBean
    Episode episodeRepository;

    @MockBean
    CharacterEpisodeRepository characterEpisodeRepository;

    @Test
    public void testGetAllByCharacter_Id(){
        Set<CharacterEpisode> expected = new HashSet<>();
        expected.add(new CharacterEpisode(new Character(5, "Wilhuff Tarkin"), new Episode(1, "NEWHOPE")));
        when(characterEpisodeRepository.getAllByCharacter_Id(anyInt())).thenReturn(expected);
        Set<Episode> expectedTitles = expected.stream().map(CharacterEpisode::getEpisode).collect(Collectors.toSet());
        Set<CharacterEpisode> result = characterEpisodeRepository.getAllByCharacter_Id(5);
        Set<Episode> resultTitles = result.stream().map(CharacterEpisode::getEpisode).collect(Collectors.toSet());
        assertThat(resultTitles.equals(expectedTitles));
    }
}
