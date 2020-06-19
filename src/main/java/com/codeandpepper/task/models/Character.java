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

    @OneToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST
            },
            mappedBy = "characters")
    private Set<CharacterEpisode> episodes;


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
        for (CharacterEpisode e : episodes){
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

    public void setEpisodes(Set<CharacterEpisode> episodes) {
        this.episodes = episodes;
    }

    public Set<CharacterEpisode> getEpisodes() {
        return episodes;
    }

//    public void setFriends(List<Friends> friends) {
//        this.friends = friends;
//    }
//
//    public List<Friends> getFriends() {
//        return friends;
//    }
}
