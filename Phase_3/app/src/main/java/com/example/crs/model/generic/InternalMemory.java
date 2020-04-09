package com.example.crs.model.generic;

import com.example.crs.model.item.Item;
import com.example.crs.model.item.ItemType;

public final class InternalMemory extends Item {
    private String formFactor;
    private int capacity;
    private int amount;

    public InternalMemory(String name, String model, String url, float price, ItemType itemType, String imageLink) {
        super(name, model, url, price, itemType, imageLink);

        if (!itemType.equals(ItemType.SSD) && !itemType.equals(ItemType.HDD) && !itemType.equals(ItemType.M2DRIVE)) {
            throw new IllegalArgumentException("Wrong Item type. Must be SSD, HDD or M2DRIVE");
        }
    }

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

    @Override
    public void setItemType(ItemType itemType) {
        if (!itemType.equals(ItemType.SSD) && !itemType.equals(ItemType.HDD) && !itemType.equals(ItemType.M2DRIVE)) {
            throw new IllegalArgumentException("Wrong Item type. Must be SSD, HDD or M2DRIVE");
        }

        super.setItemType(itemType);
    }

    @Override
    public String toString() {
        return "InternalMemory{" +
                "formFactor='" + formFactor + '\'' +
                ", capacity=" + capacity +
                ", amount=" + amount +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                ", model='" + getModel() + '\'' +
                ", url='" + getUrl() + '\'' +
                ", price=" + getPrice() +
                ", itemType=" + getItemType() +
                ", imageLink='" + getImageLink() + '\'' +
                '}';
    }
}
