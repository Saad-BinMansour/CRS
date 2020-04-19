package com.example.crs.model.laptop;

public enum DisplayResolution {
    D1366x768, D1280x800, D1280x1024, D1400x1050, D1440x900, D1600x900, D1680x1050, D1600x1200,
    D1920x1080, D1920x1200, D2560x1440, D2560x1600, D2880x1800, D3800x1800, D3840x2160,
    D4096x2160,D2160x1440;

    private static final int HD = 1920 * 1080;

    // Check id the resolution is equal or larger than full HD
    public static boolean isFullHD_OrLarger(DisplayResolution displayResolution) {
        String resolution = displayResolution.name().substring(1);
        int indexOfX = resolution.indexOf('x');
        int height = Integer.parseInt(resolution.substring(0, indexOfX));
        int width = Integer.parseInt(resolution.substring(indexOfX + 1));

        return (height * width) >= HD;
    }
}
