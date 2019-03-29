package com.melvin.tmt.model;

public class Ciudad {

    private Integer id;
    private String name;

    public Ciudad(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
