package com.codeandpepper.task.unit.repositories;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.models.Friends;
import com.codeandpepper.task.repositories.FriendsRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class FriendsRepositoryUnitTest {

    private static FriendsRepository friendsRepository;

    @BeforeClass
    public static void setUp() {
        friendsRepository = mock(FriendsRepository.class);
    }

    @Test
    public void testGetFriendsList(){
        Set<Friends> expected = new HashSet<>();
        Character no7 = new Character(7, "R2-D2");
        expected.add(new Friends(no7, new Character(1, "Luke Skywalker")));
        expected.add(new Friends(no7, new Character(3, "Han Solo")));
        expected.add(new Friends(no7, new Character(4, "Leia Organa")));

        when(friendsRepository.getAllByCharacter_Id(anyInt())).thenReturn(expected);
        Set<Friends> result = friendsRepository.getAllByCharacter_Id(3);

        assertThat(result).isNotNull()
                .isEqualToComparingOnlyGivenFields(result);
    }
}
