package com.example.crs.model.item;

public interface Itemable {
    int getID();

    void setID(int id);

    String getName();

    void setName(String name);

    String getModel();

    void setModel(String model);

    String getURL();

    void setURL(String url);

    ItemType getItemType();

    void setItemType(ItemType itemType);
}
