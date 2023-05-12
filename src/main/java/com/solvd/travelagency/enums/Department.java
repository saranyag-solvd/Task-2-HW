package com.solvd.travelagency.enums;

public enum Department {
    MANAGER(0, "Manager"),
    TRAVEL_AGENT(1, "Travel Agent"),
    HELPDESK(2, "Helpdesk");


    private int id;
    private String name;


    Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


