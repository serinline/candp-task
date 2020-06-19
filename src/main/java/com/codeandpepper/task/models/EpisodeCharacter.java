package com.codeandpepper.task.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "actors")
public class EpisodeCharacter {
//    @Column(name = "episode_id")
    private int characterId;
//    @Column(name = "character_id")
    private int episodeId;

    private Character character;
    private Episode episode;

    public void setCharacter_id(int characterId) {
        this.characterId = characterId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    public Episode getEpisode() {
        return episode;
    }
}
