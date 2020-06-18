package com.codeandpepper.task.models;

public class Friends {

    private int characterId;
    private int friendId;
    private Character character;
    private Character friend;

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
