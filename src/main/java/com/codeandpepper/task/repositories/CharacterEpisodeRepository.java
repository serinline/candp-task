package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.CharacterEpisode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CharacterEpisodeRepository extends CrudRepository<CharacterEpisode, Integer> {

    Set<CharacterEpisode> getAllByCharacter_Id(int id);

    Set<CharacterEpisode> getAllByEpisode_Id(int id);
}
