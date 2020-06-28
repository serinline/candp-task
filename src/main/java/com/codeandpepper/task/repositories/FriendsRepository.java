package com.codeandpepper.task.repositories;

import com.codeandpepper.task.models.Friends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FriendsRepository extends CrudRepository<Friends, Integer> {
    Set<Friends> getAllByCharacter_Id(int id);
}
