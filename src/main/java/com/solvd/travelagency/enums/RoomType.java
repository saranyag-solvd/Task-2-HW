package com.solvd.travelagency.enums;

public enum RoomType {
    STUDIO(0, "Apartment Style"),
    FAMILY_ROOM(1, "Rooms suitable for a family"),
    SUITE(3, "Comes with kitchen");

    private int id;
    private String description;

    RoomType(int id, String description) {
        this.id = id;
        this.description = description;
    }
}
