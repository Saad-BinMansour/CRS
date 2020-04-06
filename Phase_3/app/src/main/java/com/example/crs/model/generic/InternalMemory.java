package com.example.crs.model.generic;

import android.graphics.Bitmap;

import com.example.crs.model.item.ItemType;
import com.example.crs.model.item.Itemable;

public final class InternalMemory implements Itemable {
    private String name;
    private String model;
    private ItemType itemType;
    private int id;
    private String url;
    private String formFactor;
    private int capacity;
    private int amount;
    private float price;
    private String imageLink;

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public void setItemType(ItemType itemType) {
        if (!itemType.equals(ItemType.SSD) && !itemType.equals(ItemType.HDD) && !itemType.equals(ItemType.M2DRIVE)) {
            throw new IllegalArgumentException("Wrong Item type. Must be SSD, HDD or M2DRIVE");
        }

        this.itemType = itemType;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public String getURL() {
        return imageLink;
    }

    @Override
    public void setURL(String url) {
        this.url = url;
    }
}
