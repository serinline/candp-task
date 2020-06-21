package com.codeandpepper.task.models;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "friends")
@Transactional
public class Friends {

    @EmbeddedId
    private FriendsKey id;

    @ManyToOne
    @MapsId("characterId")
    @JoinColumn(name="character")
    private Character character;

    @ManyToOne
    @MapsId("friendId")
    @JoinColumn(name="friend")
    private Character friend;

    public Friends(){}

    public Friends(Character character, Character friend){
        this.setCharacter(character);
        this.setFriend(friend);
    }

    public void setId(FriendsKey id) {
        this.id = id;
    }

    public FriendsKey getId() {
        return id;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setFriend(Character friend) {
        this.friend = friend;
    }

    public Character getFriend() {
        return friend;
    }
}
