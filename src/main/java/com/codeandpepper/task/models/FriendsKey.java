package com.codeandpepper.task.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FriendsKey implements Serializable {

    @Column(name="character")
    private int characterId;

    @Column(name="friend")
    private int friendId;

    private FriendsKey(){}

    public FriendsKey(int characterId, int friendId){
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        FriendsKey that = (FriendsKey) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(friendId, that.friendId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, friendId);
    }
}
