package com.example.crs.model.laptop;

import com.example.crs.model.generic.CPU;
import com.example.crs.model.generic.GPU;
import com.example.crs.model.generic.InternalMemory;
import com.example.crs.model.generic.RAM;
import com.example.crs.model.item.Item;
import com.example.crs.model.item.ItemType;

public final class ComputerItem extends Item {
    private Display display;
    private Battery battery;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private InternalMemory hdd;
    private InternalMemory ssd;
    private InternalMemory m2Drive;

    public ComputerItem() {
    }

    public ComputerItem(String name, String model, String url, float price, ItemType itemType, String imageLink) {
        super(name, model, url, price, itemType, imageLink);

        if (!itemType.equals(ItemType.NOTEBOOK) && !itemType.equals(ItemType.ULTRABOOK)
                && !itemType.equals(ItemType.CHROMEBOOK) && !itemType.equals(ItemType.MACBOOK)
                && !itemType.equals(ItemType.CONVERTIBLE) && !itemType.equals(ItemType.TABLET)) {
            throw new IllegalArgumentException("Wrong Item type. Must be notebook, ultrabook, " +
                    "chromebook, macbook, convertible or tablet");
        }
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

    @Override
    public void setItemType(ItemType itemType) {
        if (!itemType.equals(ItemType.NOTEBOOK) && !itemType.equals(ItemType.ULTRABOOK)
                && !itemType.equals(ItemType.CHROMEBOOK) && !itemType.equals(ItemType.MACBOOK)
                && !itemType.equals(ItemType.CONVERTIBLE) && !itemType.equals(ItemType.TABLET)) {
            throw new IllegalArgumentException("Wrong Item type. Must be notebook, ultrabook, " +
                    "chromebook, macbook, convertible or tablet");
        }

        super.setItemType(itemType);
    }

    @Override
    public String toString() {
        return "ComputerItem{" +
                "display=" + display +
                ", battery=" + battery +
                ", cpu=" + cpu +
                ", gpu=" + gpu +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", ssd=" + ssd +
                ", m2Drive=" + m2Drive +
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
