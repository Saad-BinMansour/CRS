package com.example.crs.model.desktop;

import com.example.crs.model.item.Item;
import com.example.crs.model.item.ItemType;

import org.jetbrains.annotations.NotNull;

public final class PowerSupply extends Item {
    private int watts;

    public PowerSupply() {
    }

    public PowerSupply(String name, String model, String url, float price, ItemType itemType, String imageLink) {
        super(name, model, url, price, itemType, imageLink);
    }

    public int getWatts() {
        return watts;
    }

    public void setWatts(int watts) {
        this.watts = watts;
    }

    @NotNull
    @Override
    public String toString() {
        return getName();
    }
}
