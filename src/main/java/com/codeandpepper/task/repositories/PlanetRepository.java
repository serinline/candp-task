package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.Planet;
import org.springframework.data.repository.CrudRepository;

public interface PlanetRepository extends CrudRepository<Planet, Integer> {
}
