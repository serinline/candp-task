package com.codeandpepper.task.models;


import java.util.List;

public class Character {
    private int id;
    private String name;
    private List<EpisodeCharacter> episodeCharacters;
    private List<Friends> friends;

    public Character(){}

    public Character(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEpisodeCharacters(List<EpisodeCharacter> episodeCharacters) {
        this.episodeCharacters = episodeCharacters;
    }

    public List<EpisodeCharacter> getEpisodeCharacters() {
        return episodeCharacters;
    }

    public void setFriends(List<Friends> friends) {
        this.friends = friends;
    }

    public List<Friends> getFriends() {
        return friends;
    }
}
