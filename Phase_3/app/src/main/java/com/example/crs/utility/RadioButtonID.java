package com.example.crs.utility;

public enum RadioButtonID {
    STUDY(2000), BROWSE(2001), EDITING(2002), GAMING(2003), SCREEN(3000), PERFORMANCE(3001), PORTABILITY(3002);

    private int id;

    RadioButtonID(int id) {
        this.id = id;
    }

    // Get the radio button's id
    public int getId() {
        return id;
    }

    // Returns the type that matches the id
    public static RadioButtonID getTypeById(int radioButtonId) {
        switch (radioButtonId) {
            case 2000:
                return STUDY;

            case 2001:
                return BROWSE;

            case 2002:
                return EDITING;

            case 2003:
                return GAMING;

            case 3000:
                return SCREEN;

            case 3001:
                return PERFORMANCE;

            case 3002:
                return PORTABILITY;

            default:
                throw new IllegalArgumentException("No matching radio button id");
        }
    }
}
