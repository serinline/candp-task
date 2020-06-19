package com.codeandpepper.task.models;

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

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST})
    @JoinTable(
            name = "actors",
            joinColumns = {
                    @JoinColumn(name = "episode_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "character_id", referencedColumnName = "id")})
    private Set<Character> characters;

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

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public Set<Character> getCharacters() {
        return characters;
    }
}
