package com.codeandpepper.task.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
@Table(name = "characters")
@Transactional
public class Character {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "planet")
    private Integer homePlanet;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "character")
    private Set<CharacterEpisode> episodes;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "character")
    private Set<Friends> friends;

    protected Character(){}

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

    public void setHomePlanet(Integer planetId) {
        this.homePlanet = planetId;
    }

    public Integer getHomePlanet() {
        return homePlanet;
    }

    public void setEpisodes(Set<CharacterEpisode> episodes) {
        this.episodes = episodes;
    }

    public Set<CharacterEpisode> getEpisodes() {
        return episodes;
    }

    public void setFriends(Set<Friends> friends) {
        this.friends = friends;
    }

    public Set<Friends> getFriends() {
        return friends;
    }
}
