package com.example.crs.model.item;

public enum ItemType {
    NOTEBOOK, ULTRABOOK, CHROMEBOOK, MACBOOK, CONVERTIBLE, TABLET;

    public String getComputerTypeString(ItemType itemType) {
        switch (itemType) {
            case TABLET:
                return "Tablet";

            case MACBOOK:
                return "Mac book";

            case NOTEBOOK:
                return "Notebook";

            case ULTRABOOK:
                return "Ultrabook";

            case CHROMEBOOK:
                return "Chromebook";

            case CONVERTIBLE:
                return "Convertible";

            default:
                throw new IllegalArgumentException("Invalid Computer Type");
        }
    }
}
