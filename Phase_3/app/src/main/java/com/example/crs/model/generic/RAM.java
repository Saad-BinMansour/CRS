package com.example.crs.model.generic;

import android.graphics.Bitmap;

public final class RAM {
    private String name;
    private String model;
    private int capacity;
    private int speed;
    private int CASLatency;
    private float price;
    private String imageLink;

    public RAM() {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCASLatency() {
        return CASLatency;
    }

    public void setCASLatency(int CASLatency) {
        this.CASLatency = CASLatency;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", speed=" + speed +
                ", CASLatency=" + CASLatency +
                ", price=" + price +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
