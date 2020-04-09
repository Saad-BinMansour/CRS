package com.example.crs.model.item;

public abstract class Item {
    private static final int DEFAULT_ID = 0;
    private int id;
    private String name;
    private String model;
    private String url;
    private float price;
    private ItemType itemType;
    private String imageLink;

    public Item(String name, String model, String url, float price, ItemType itemType, String imageLink) {
        this.id = DEFAULT_ID;
        this.name = name;
        this.model = model;
        this.url = url;
        this.price = price;
        this.itemType = itemType;
        this.imageLink = imageLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
