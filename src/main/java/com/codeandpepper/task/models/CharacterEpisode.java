package com.codeandpepper.task.models;

import javax.persistence.*;

@Entity
@Table(name = "actors")
public class CharacterEpisode {

    @EmbeddedId
    CharacterEpisodeKey id;

    @ManyToOne
    @MapsId("character_id")
    @JoinColumn(name="character_id")
    private Character character;

    @ManyToOne
    @MapsId("episode_id")
    @JoinColumn(name="episode_id")
    private Episode episode;

    public CharacterEpisode(){}

    public CharacterEpisode(Character character, Episode episode){
        this.setCharacter(character);
        this.setEpisode(episode);
    }

    public void setId(CharacterEpisodeKey id) {
        this.id = id;
    }

    public CharacterEpisodeKey getId() {
        return id;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public Episode getEpisode() {
        return episode;
    }
}
