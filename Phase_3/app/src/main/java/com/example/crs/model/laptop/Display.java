package com.example.crs.model.laptop;

public final class Display {
    private float size;
    private DisplayResolution displayResolution;
    private ScreenType screenType;
    private boolean touchscreen;

    public Display(float size, DisplayResolution displayResolution, ScreenType screenType, boolean touchscreen) {
        this.size = size;
        this.displayResolution = displayResolution;
        this.screenType = screenType;
        this.touchscreen = touchscreen;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public DisplayResolution getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(DisplayResolution displayResolution) {
        this.displayResolution = displayResolution;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }

    public boolean isTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(boolean touchscreen) {
        this.touchscreen = touchscreen;
    }

    @Override
    public String toString() {
        return "Display{" +
                "size=" + size +
                ", displayResolution=" + displayResolution +
                ", screenType=" + screenType +
                ", touchscreen=" + touchscreen +
                '}';
    }
}
