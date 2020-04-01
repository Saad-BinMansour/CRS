package com.example.crs.model.generic;

import android.graphics.Bitmap;

public final class GPU {
    private String name;
    private String model;
    private int memorySize;
    private float length;
    private float height;
    private float price;
    private Bitmap image;

    public GPU() {
    }

    public GPU(String name, String model, int memorySize, float length, float height, float price, Bitmap image) {
        this.name = name;
        this.model = model;
        this.memorySize = memorySize;
        this.length = length;
        this.height = height;
        this.price = price;
        this.image = image;
    }

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

    @Override
    public String toString() {
        return "GPU{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", memorySize=" + memorySize +
                ", length=" + length +
                ", height=" + height +
                ", price=" + price +
                ", image=" + image +
                '}';
    }
}
