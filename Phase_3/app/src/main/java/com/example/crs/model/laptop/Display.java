package com.example.crs.model.laptop;

public final class Display {
    private float size;
    private DisplayResolution displayResolution;
    private ScreenType screenType;
    private boolean touchscreen;
    private int hertz;
    private float ms;
    private float ntsc;
    private float sRGB;
    private float aRGB;

    public Display() {
    }

    public Display(float size, DisplayResolution displayResolution, ScreenType screenType, boolean touchscreen, int hertz, int ms, int ntsc, int sRGB) {
        this.size = size;
        this.displayResolution = displayResolution;
        this.screenType = screenType;
        this.touchscreen = touchscreen;
        this.hertz = hertz;
        this.ms = ms;
        this.ntsc = ntsc;
        this.sRGB = sRGB;
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

    public int getHertz() {
        return hertz;
    }

    public void setHertz(int hertz) {
        this.hertz = hertz;
    }

    public float getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public float getNtsc() {
        return ntsc;
    }

    public void setNtsc(int ntsc) {
        this.ntsc = ntsc;
    }

    public float getsRGB() {
        return sRGB;
    }

    public void setsRGB(int sRGB) {
        this.sRGB = sRGB;
    }

    public float getaRGB() {
        return aRGB;
    }

    public void setaRGB(float aRGB) {
        this.aRGB = aRGB;
    }

    @Override
    public String toString() {
        if (screenType == ScreenType.OLED || screenType == ScreenType.AMOLED) {
            return size + "\" " + displayResolution.name().substring(1)
                    + " " + screenType.name() + " " + hertz + " Hz";
        }

        return size + "\" " + displayResolution.name().substring(1)
                + " " + screenType.name() + " " + hertz + " Hz ";
    }
}
