package com.example.crs.model.generic;

import android.graphics.Bitmap;

public final class CPU {
    private String name;
    private String model;
    private SocketType socketType;
    private int numberOfCores;
    private int numberOfThreads;
    private int thermalDesign;
    private float operatingFrequency;
    private float maxTurboBoost;
    private float price;
    private String imageLink;

    public CPU() {
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

    public SocketType getSocketType() {
        return socketType;
    }

    public void setSocketType(SocketType socketType) {
        this.socketType = socketType;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public int getThermalDesign() {
        return thermalDesign;
    }

    public void setThermalDesign(int thermalDesign) {
        this.thermalDesign = thermalDesign;
    }

    public float getOperatingFrequency() {
        return operatingFrequency;
    }

    public void setOperatingFrequency(float operatingFrequency) {
        this.operatingFrequency = operatingFrequency;
    }

    public float getMaxTurboBoost() {
        return maxTurboBoost;
    }

    public void setMaxTurboBoost(float maxTurboBoost) {
        this.maxTurboBoost = maxTurboBoost;
    }

    @Override
    public String toString() {
        return "CPU{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", socketType=" + socketType +
                ", numberOfCores=" + numberOfCores +
                ", numberOfThreads=" + numberOfThreads +
                ", thermalDesign=" + thermalDesign +
                ", operatingFrequency=" + operatingFrequency +
                ", maxTurboBoost=" + maxTurboBoost +
                '}';
    }
}
