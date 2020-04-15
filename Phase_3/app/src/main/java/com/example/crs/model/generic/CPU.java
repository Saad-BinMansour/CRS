package com.example.crs.model.generic;

import com.example.crs.model.item.Item;
import com.example.crs.model.item.ItemType;

public final class CPU extends Item {
    private SocketType socketType;
    private int numberOfCores;
    private int numberOfThreads;
    private int thermalDesign;
    private float operatingFrequency;
    private float maxTurboBoost;

    public CPU() {
    }

    public CPU(String name, String model, String url, float price, ItemType itemType, String imageLink) {
        super(name, model, url, price, itemType, imageLink);

        if (!itemType.equals(ItemType.CPU)) {
            throw new IllegalArgumentException("Wrong Item type. Must be CPU");
        }
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
    public void setItemType(ItemType itemType) {
        if (!itemType.equals(ItemType.CPU)) {
            throw new IllegalArgumentException("Wrong Item type. Must be CPU");
        }

        super.setItemType(itemType);
    }

    @Override
    public String toString() {
        return "CPU{" +
                "socketType=" + socketType +
                ", numberOfCores=" + numberOfCores +
                ", numberOfThreads=" + numberOfThreads +
                ", thermalDesign=" + thermalDesign +
                ", operatingFrequency=" + operatingFrequency +
                ", maxTurboBoost=" + maxTurboBoost +
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
