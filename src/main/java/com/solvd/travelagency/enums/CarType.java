package com.solvd.travelagency.enums;

public enum CarType {

    SEDAN(0, "5 Seaters"),
    SUV(1, "Family Vehicle"),
    CROSSOVER(3, "Small Family Vehicle");


    private int id;
    private String description;

    CarType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
