package com.example.crs.model.desktop;

import com.example.crs.model.generic.CPU;
import com.example.crs.model.generic.GPU;
import com.example.crs.model.generic.InternalMemory;
import com.example.crs.model.generic.RAM;
import com.example.crs.model.item.Item;
import com.example.crs.model.item.ItemType;

public final class DesktopItem extends Item {
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private InternalMemory hdd;
    private Motherboard motherboard;
    private PowerSupply powerSupply;
    private Case aCase;

    public DesktopItem() {
    }

    public DesktopItem(String name, String model, String url, float price, ItemType itemType, String imageLink) {
        super(name, model, url, price, itemType, imageLink);
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
        setPrice(getPrice() + cpu.getPrice());
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
        setPrice(getPrice() + gpu.getPrice());
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
        setPrice(getPrice() + ram.getPrice());
    }

    public InternalMemory getHdd() {
        return hdd;
    }

    public void setHdd(InternalMemory hdd) {
        this.hdd = hdd;
        this.hdd.setItemType(ItemType.HDD);
        setPrice(getPrice() + hdd.getPrice());
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        setPrice(getPrice() + motherboard.getPrice());
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
        setPrice(getPrice() + powerSupply.getPrice());
    }

    public Case getaCase() {
        return aCase;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
        setPrice(getPrice() + cpu.getPrice());
    }

    @Override
    public String toString() {
        return cpu.getName() + "\n" +
                gpu.getName() + "\n" +
                motherboard.getName() + "\n" +
                ram.getName() + "\n" +
                hdd.getName() + "\n" +
                powerSupply.getName() + "\n" +
                aCase.getName();
    }
}
