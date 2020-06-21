package com.codeandpepper.task.models;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Objects;

@Entity
@Table(name = "actors")
@Transactional
public class CharacterEpisode {

    @EmbeddedId
    CharacterEpisodeKey id;

    @ManyToOne
    @MapsId("characterId")
    @JoinColumn(name="character_id")
    private Character character;

    @ManyToOne
    @MapsId("episodeId")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CharacterEpisode that = (CharacterEpisode) o;
        return Objects.equals(character, that.character) &&
                Objects.equals(episode, that.episode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, episode);
    }
}
