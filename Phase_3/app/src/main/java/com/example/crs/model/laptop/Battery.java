package com.example.crs.model.laptop;

public final class Battery {
    private int WHrs;
    private int consumption;

    public Battery(int WHrs) {
        this.WHrs = WHrs;
    }

    public Battery(int WHrs, int consumption) {
        this.WHrs = WHrs;
        this.consumption = consumption;
    }

    public int getWHrs() {
        return WHrs;
    }

    public void setWHrs(int WHrs) {
        this.WHrs = WHrs;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "WHrs=" + WHrs +
                ", consumption=" + consumption +
                '}';
    }
}
