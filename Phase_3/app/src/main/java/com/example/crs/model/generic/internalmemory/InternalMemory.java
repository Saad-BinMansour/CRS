package com.example.crs.model.generic.internalmemory;

import android.graphics.Bitmap;

public abstract class InternalMemory {
    private String name;
    private String model;
    private InternalMemoryType internalMemoryType;
    private String formFactor;
    private int capacity;
    private int amount;
    private float price;
    private Bitmap image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public InternalMemoryType getInternalMemoryType() {
        return internalMemoryType;
    }

    public void setInternalMemoryType(InternalMemoryType internalMemoryType) {
        this.internalMemoryType = internalMemoryType;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
