package com.codeandpepper.task.models;


import javax.persistence.*;
import java.util.List;
import javax.persistence.Id;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

//    private List<EpisodeCharacter> episodeCharacters;
//    private List<Friends> friends;

    protected Character(){}

    public Character(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    @Override
    public String toString() {
        return String.format(
                "Character[id=%d, name='%s']",
                id, name);
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

//    public void setEpisodeCharacters(List<EpisodeCharacter> episodeCharacters) {
//        this.episodeCharacters = episodeCharacters;
//    }
//
//    public List<EpisodeCharacter> getEpisodeCharacters() {
//        return episodeCharacters;
//    }
//
//    public void setFriends(List<Friends> friends) {
//        this.friends = friends;
//    }
//
//    public List<Friends> getFriends() {
//        return friends;
//    }
}
