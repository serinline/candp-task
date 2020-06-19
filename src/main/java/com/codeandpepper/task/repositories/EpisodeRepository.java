package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.Episode;
import org.springframework.data.repository.CrudRepository;

public interface EpisodeRepository extends CrudRepository<Episode, Integer> {
}
