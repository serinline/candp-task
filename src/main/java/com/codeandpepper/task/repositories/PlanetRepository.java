package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.Planet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Integer> {
}
