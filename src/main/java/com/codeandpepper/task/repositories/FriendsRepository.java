package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.Friends;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface FriendsRepository extends CrudRepository<Friends, Integer> {
    Set<Friends> getAllByCharacter_Id(int id);
}
