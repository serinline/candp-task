package com.codeandpepper.task.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CharacterEpisodeKey implements Serializable {

    @Column(name="character_id")
    int characterId;

    @Column(name="episode_id")
    int episodeId;

    private CharacterEpisodeKey(){}

    public CharacterEpisodeKey(int characterId, int episodeId){
        this.setCharacterId(characterId);
        this.setEpisodeId(episodeId);
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CharacterEpisodeKey that = (CharacterEpisodeKey) o;
        return Objects.equals(characterId, that.characterId) &&
                Objects.equals(episodeId, that.episodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterId, episodeId);
    }
}
