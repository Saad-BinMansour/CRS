package com.example.crs.model.item;

public enum ComputerItemType {
    NOTEBOOK, ULTRABOOK, CHROMEBOOK, MACBOOK, CONVERTIBLE, TABLET;

    public String getComputerTypeString(ComputerItemType computerItemType) {
        switch (computerItemType) {
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
