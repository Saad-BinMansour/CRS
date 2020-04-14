package com.example.crs.model.laptop;

import com.example.crs.model.generic.CPU;
import com.example.crs.model.generic.GPU;
import com.example.crs.model.generic.InternalMemory;
import com.example.crs.model.generic.Ports;
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
    private InternalMemory NVMeSSD;
    private Ports ports;
    private float height;
    private float width;
    private float depth;
    private float weight;

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

    public void setHdd(int capacity) {
        this.hdd = new InternalMemory();
        this.hdd.setItemType(ItemType.HDD);
        this.hdd.setCapacity(capacity);
    }

    public InternalMemory getSsd() {
        return ssd;
    }

    public void setSsd(int capacity) {
        this.ssd = new InternalMemory();
        this.ssd.setItemType(ItemType.SSD);
        this.ssd.setCapacity(capacity);
    }

    public InternalMemory getM2Drive() {
        return m2Drive;
    }

    public void setM2Drive(int capacity) {
        this.m2Drive = new InternalMemory();
        this.m2Drive.setItemType(ItemType.M2DRIVE);
        this.m2Drive.setCapacity(capacity);
    }

    public InternalMemory getNVMeSSD() {
        return NVMeSSD;
    }

    public void setNVMeSSD(int capacity) {
        this.NVMeSSD = new InternalMemory();
        this.NVMeSSD.setItemType(ItemType.NVMeSSD);
        this.NVMeSSD.setCapacity(capacity);
    }

    public Ports getPorts() {
        return ports;
    }

    public void setPorts(Ports ports) {
        this.ports = ports;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setDimensions(float width, float depth, float height) {
        this.height = height;
        this.width = width;
        this.depth = depth;
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
        return getName() + "\n"
                + cpu.getName() + "\n"
                + gpu.getName() + "\n"
                + ram.getName() + "\n"
                + display + "\n"
                + width + " mm x " + depth + " mm x " + height + " mm " + weight + " kg" +  "\n"
                + getAvailableInternalMem() + "\n"
                + ports;
    }

    private String getAvailableInternalMem() {
        StringBuilder stringBuilder = new StringBuilder();
        if (hdd != null) {
            stringBuilder.append(hdd.getCapacity()).append(" GB ").append("HDD").append("\n");
        }
        if (ssd != null) {
            stringBuilder.append(ssd.getCapacity()).append(" GB ").append("SSD").append("\n");
        }
        if (m2Drive != null) {
            stringBuilder.append(m2Drive.getCapacity()).append(" GB ").append("m2Drive").append("\n");
        }
        if (NVMeSSD != null) {
            stringBuilder.append(NVMeSSD.getCapacity()).append(" GB ").append("NVMeSSD");
        }

        return stringBuilder.toString();
    }
}
