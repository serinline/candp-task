package com.codeandpepper.task.models;


import javax.persistence.*;
import java.util.List;
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

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "episodeCharacters")
    private Set<Episode> characterEpisodes;


//    private List<Friends> friends;

    protected Character(){}

    public Character(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += id;
        ret += name;
        for (Episode e : characterEpisodes){
            ret += e.toString();
        }
        return ret;
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

    public void setEpisodeCharacters(Set<Episode> characterEpisodes) {
        this.characterEpisodes = characterEpisodes;
    }

    public Set<Episode> getEpisodeCharacters() {
        return characterEpisodes;
    }

//    public void setFriends(List<Friends> friends) {
//        this.friends = friends;
//    }
//
//    public List<Friends> getFriends() {
//        return friends;
//    }
}
