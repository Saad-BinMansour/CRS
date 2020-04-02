package com.example.crs.model.item;

import android.graphics.Bitmap;

import com.example.crs.model.generic.CPU;
import com.example.crs.model.generic.GPU;
import com.example.crs.model.generic.RAM;
import com.example.crs.model.generic.internalmemory.*;
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
    private HDD hdd;
    private SSD ssd;
    private M2Drive m2Drive;
    private float price;
    private ItemType itemType;
    private Bitmap bitmap;

    public ComputerItem() {
    }

    public ComputerItem(int id, String name, String model, String url, Display display,
                        Battery battery, CPU cpu, GPU gpu, RAM ram, HDD hdd, SSD ssd,
                        M2Drive m2Drive, float price, ItemType itemType, Bitmap bitmap) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.url = url;
        this.display = display;
        this.battery = battery;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.hdd = hdd;
        this.ssd = ssd;
        this.m2Drive = m2Drive;
        this.price = price;
        this.itemType = itemType;
        this.bitmap = bitmap;
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

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public SSD getSsd() {
        return ssd;
    }

    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public M2Drive getM2Drive() {
        return m2Drive;
    }

    public void setM2Drive(M2Drive m2Drive) {
        this.m2Drive = m2Drive;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
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
                ", bitmap=" + bitmap +
                '}';
    }
}
