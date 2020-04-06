package com.example.crs.model.item;

import android.graphics.Bitmap;

import com.example.crs.model.generic.CPU;
import com.example.crs.model.generic.GPU;
import com.example.crs.model.generic.InternalMemory;
import com.example.crs.model.generic.RAM;
import com.example.crs.model.laptop.*;

public final class ComputerItem implements Itemable {
    private int id;
    private String name;
    private String model;
    private String url;
    private Display display;
    private Battery battery;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private InternalMemory hdd;
    private InternalMemory ssd;
    private InternalMemory m2Drive;
    private float price;
    private ItemType itemType;
    private String imageLink;

    public ComputerItem() {
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public InternalMemory getHdd() {
        return hdd;
    }

    public void setHdd(InternalMemory hdd) {
        this.hdd = hdd;
    }

    public InternalMemory getSsd() {
        return ssd;
    }

    public void setSsd(InternalMemory ssd) {
        this.ssd = ssd;
    }

    public InternalMemory getM2Drive() {
        return m2Drive;
    }

    public void setM2Drive(InternalMemory m2Drive) {
        this.m2Drive = m2Drive;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
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
    public String getURL() {
        return url;
    }

    @Override
    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public void setItemType(ItemType itemType) {
        if (!itemType.equals(ItemType.ULTRABOOK) && !itemType.equals(ItemType.NOTEBOOK) && !itemType.equals(ItemType.CHROMEBOOK)
                && !itemType.equals(ItemType.MACBOOK) && !itemType.equals(ItemType.CONVERTIBLE)
                && !itemType.equals(ItemType.TABLET)) {
            throw new IllegalArgumentException("Wrong Item type. Must be NOTEBOOK, ULTRABOOK, CHROMEBOOK" +
                    ", MACBOOK, CONVERTIBLE, TABLET");
        }

        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "ComputerItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", url='" + url + '\'' +
                ", display=" + display +
                ", battery=" + battery +
                ", cpu=" + cpu +
                ", gpu=" + gpu +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", ssd=" + ssd +
                ", m2Drive=" + m2Drive +
                ", price=" + price +
                ", itemType=" + itemType +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
