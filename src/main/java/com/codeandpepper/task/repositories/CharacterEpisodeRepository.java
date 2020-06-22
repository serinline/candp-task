package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.CharacterEpisode;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CharacterEpisodeRepository extends CrudRepository<CharacterEpisode, Integer> {

    Set<CharacterEpisode> getAllByCharacter_Id(int id);

    Set<CharacterEpisode> getAllByEpisode_Id(int id);
}
