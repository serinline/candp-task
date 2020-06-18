package com.codeandpepper.task.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "episode")
public class Episode {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    private List<EpisodeCharacter> episodeCharacters;

    public Episode(){}

    public Episode(int id, String title){
        this.setId(id);
        this.setTitle(title);
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

    public void setEpisodeCharacters(List<EpisodeCharacter> episodeCharacters) {
        this.episodeCharacters = episodeCharacters;
    }

    public List<EpisodeCharacter> getEpisodeCharacters() {
        return episodeCharacters;
    }
}
