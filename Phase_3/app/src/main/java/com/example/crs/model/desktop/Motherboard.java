package com.example.crs.model.desktop;

import com.example.crs.model.generic.SocketType;
import com.example.crs.model.item.Item;
import com.example.crs.model.item.ItemType;

import org.jetbrains.annotations.NotNull;

public final class Motherboard extends Item {
    private SocketType socketType;
    private FormFactor formFactor;

    public Motherboard() {
    }

    public Motherboard(String name, String model, String url, float price, ItemType itemType, String imageLink) {
        super(name, model, url, price, itemType, imageLink);
    }

    public SocketType getSocketType() {
        return socketType;
    }

    public void setSocketType(SocketType socketType) {
        this.socketType = socketType;
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
    }

    @NotNull
    @Override
    public String toString() {
        return getName();
    }
}
