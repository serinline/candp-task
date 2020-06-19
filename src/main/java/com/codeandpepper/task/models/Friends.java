package com.codeandpepper.task.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "friends")
public class Friends {
//    @Column(name = "character")
    private int characterId;
//    @Column(name = "friend")
    private int friendId;
    private Character character;
    private Character friend;

    public Friends(){}

    public Friends(int characterId, int friendId){
        this.setCharacterId(characterId);
        this.setFriendId(friendId);
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public int getFriendId() {
        return friendId;
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
