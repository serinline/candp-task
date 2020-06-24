package com.codeandpepper.task.unit;

import com.codeandpepper.task.models.Character;
import com.codeandpepper.task.models.Friends;
import com.codeandpepper.task.repositories.FriendsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class FriendsRepositoryUnitTest {

    @Autowired
    FriendsRepository friendsRepository;

    @MockBean
    private RestTemplate template;

    @Test
    public void testGetFriendsList(){
        Set<Friends> expected = new HashSet<>();
        Character no7 = new Character(7, "R2-D2");
        expected.add(new Friends(no7, new Character(1, "Luke Skywalker")));
        expected.add(new Friends(no7, new Character(3, "Han Solo")));
        expected.add(new Friends(no7, new Character(4, "Leia Organa")));

        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity<>(expected, HttpStatus.OK));
        Set<Friends> result = friendsRepository.getAllByCharacter_Id(3);
        assertThat(result).isNotNull()
                .isEqualToComparingOnlyGivenFields(result);
    }
}
