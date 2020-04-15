package com.example.crs.utility;

import com.example.crs.model.item.Item;
import com.example.crs.model.laptop.ComputerItem;
import com.example.crs.model.laptop.DisplayResolution;

import java.util.ArrayList;
import java.util.LinkedList;

public final class ResultProcess {
    private static final float MAX_WEIGHT = 2f;
    private static final float PREF_SCREEN_SIZE = 15f;
    private static final float AVE_CORE_FREQ = 2.3f;
    private static final int PREF_PERFORMANCE_NUM_CORES = 6;
    private static final int PREF_BROWSE_RAM_CAPACITY = 4;
    private static final int PREF_GAMING_RAM_CAPACITY = 8;
    private static final int PREF_GAMING_GPU_CAPACITY = 6;
    private static final int PREF_EDITING_GPU_CAPACITY = 4;
    private static final int PREF_EDITING_RAM_CAPACITY = 16;
    private static final int PREF_EDITING_NUM_CORES = 6;

    // Takes user's data and process it. Then returns information matching user's preference
    public static ArrayList<Item> getResult(
            ArrayList<Item> items, int minPrice, int maxPrice,
            RadioButtonID useRadioId, RadioButtonID matterRadioId,
            boolean laptopIsChecked, boolean desktopIsChecked) {

        // If the min price is larger than max price, switch them
        if (minPrice > maxPrice) {
            int temp = maxPrice;
            maxPrice = minPrice;
            minPrice = temp;
        }

        ArrayList<Item> result = new ArrayList<>(); // List of final results
        if (laptopIsChecked) {
            // Add results from getComputerResult method
            result.addAll(getComputerResult(items, minPrice, maxPrice, useRadioId, matterRadioId));
        }

        if (desktopIsChecked) {
            // Add desktop result function here <------------
        }

        return result;
    }

    private static ArrayList<Item> getComputerResult(ArrayList<Item> items,
                                                                int minPrice, int maxPrice,
                                                                RadioButtonID useRadioId, RadioButtonID matterRadioId) {
        LinkedList<ComputerItem> computerItemLinkedList = new LinkedList<>();
        LinkedList<Item> resultItems = new LinkedList<>();

        // Moves computerItem objects from array of item into computerItemLinkedList
        for (Item item : items) {
            if (item instanceof ComputerItem && item.getPrice() >= minPrice && item.getPrice() <= maxPrice) {
                computerItemLinkedList.add((ComputerItem) item);
            }
        }

        // Iterate through the list and choose items that are within user's preference
        for (ComputerItem computerItem : computerItemLinkedList) {
            boolean isMatchUserUsage = false;
            boolean isMatchUserMatterMost = false;

            // Average cpu frequency of the current computer item
            float averageFreq = (computerItem.getCpu().getOperatingFrequency() + computerItem.getCpu().getMaxTurboBoost()) / 2;

            // What the user use the computer for?
            switch (useRadioId) {
                case STUDY:
                    if (averageFreq >= AVE_CORE_FREQ) {
                        isMatchUserUsage = true;
                    }
                    break;

                case BROWSE:
                    if (DisplayResolution.isFullHD_OrLarger(computerItem.getDisplay().getDisplayResolution())
                            && computerItem.getRam().getCapacity() >= PREF_BROWSE_RAM_CAPACITY) {
                        isMatchUserUsage = true;
                    }
                    break;

                case GAMING:
                    if (computerItem.getRam().getCapacity() >= PREF_GAMING_RAM_CAPACITY
                            && DisplayResolution.isFullHD_OrLarger(computerItem.getDisplay().getDisplayResolution())
                            && averageFreq >= (AVE_CORE_FREQ * 1.2)
                            && computerItem.getGpu().getMemorySize() >= PREF_GAMING_GPU_CAPACITY) {
                        isMatchUserUsage = true;
                    }
                    break;

                case EDITING:
                    if (computerItem.getRam().getCapacity() >= PREF_EDITING_RAM_CAPACITY
                            && computerItem.getCpu().getNumberOfCores() >= PREF_EDITING_NUM_CORES
                            && computerItem.getGpu().getMemorySize() >= PREF_EDITING_GPU_CAPACITY)
                        isMatchUserUsage = true;
                    break;

                default:
                    throw new IllegalArgumentException("useRadioId not found");
            }

            // What matter most to the user
            switch (matterRadioId) {
                case SCREEN:
                    if (computerItem.getDisplay().getSize() >= PREF_SCREEN_SIZE) {
                        isMatchUserMatterMost = true;
                    }
                    break;

                case PERFORMANCE:
                    if (computerItem.getCpu().getNumberOfCores() >= PREF_PERFORMANCE_NUM_CORES) {
                        isMatchUserMatterMost = true;
                    }
                    break;

                case PORTABILITY:
                    if (computerItem.getWeight() <= MAX_WEIGHT) {
                        isMatchUserMatterMost = true;
                    }
                    break;

                default:
                    throw new IllegalArgumentException("matterRadioId not found");
            }

            // If the computer matches the user preference add it to the list
            if (isMatchUserMatterMost && isMatchUserUsage) {
                resultItems.add(computerItem);
            }
        }

        return new ArrayList<>(resultItems);
    }
}
