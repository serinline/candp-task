package com.codeandpepper.task.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Set;

@Entity
@Table(name = "episodes")
@Transactional
public class Episode {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "episode")
    private Set<CharacterEpisode> characters;


    public Episode(){}

    public Episode(int id, String title){
        this.setId(id);
        this.setTitle(title);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += id;
        ret += title;
        ret += " ";
        for (CharacterEpisode e : characters){
            ret += e.getCharacter().getName();
            ret += " ";
        }

        return ret;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCharacters(Set<CharacterEpisode> characters) {
        this.characters = characters;
    }

    public Set<CharacterEpisode> getCharacters() {
        return characters;
    }
}
