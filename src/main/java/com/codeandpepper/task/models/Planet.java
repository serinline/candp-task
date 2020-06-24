package com.codeandpepper.task.models;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "planets")
@Transactional
public class Planet {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    private Planet(){}

    public Planet(int id, String name){
        this.setId(id);
        this.setName(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
