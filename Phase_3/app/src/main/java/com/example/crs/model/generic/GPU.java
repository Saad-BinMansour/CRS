package com.example.crs.model.generic;

import com.example.crs.model.item.Item;
import com.example.crs.model.item.ItemType;

import org.jetbrains.annotations.NotNull;

public final class GPU extends Item {
    private int memorySize;
    private float length;
    private float height;

    public GPU() {
    }

    public GPU(String name, String model, String url, float price, ItemType itemType, String imageLink) {
        super(name, model, url, price, itemType, imageLink);

        if (!itemType.equals(ItemType.GPU)) {
            throw new IllegalArgumentException("Wrong Item type. Must be GPU");
        }
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public void setItemType(ItemType itemType) {
        if (!itemType.equals(ItemType.GPU)) {
            throw new IllegalArgumentException("Wrong Item type. Must be GPU");
        }

        super.setItemType(itemType);
    }

    @NotNull
    @Override
    public String toString() {
        return getName();
    }
}
