package com.niantic.part_3_challenge;

public class Refrigerator
{
    private int currentTemperature ;
    private int maxCapacity;
    private int available;
    private boolean isDoorOpen;

    public Refrigerator(int currentTemperature, int maxCapacity)
    {
        this.currentTemperature = currentTemperature;
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getAvailable() {
        return available;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void openDoor()
    {
        isDoorOpen = true;
    }

    public void closeDoor()
    {
        isDoorOpen = false;
    }

    public boolean addItem(int capacity)
    {
        if (isDoorOpen && capacity < maxCapacity)
        {
            available = maxCapacity - capacity;
            return true;
        }
        return false;
    }

    public int removeItem(int desiredFloor)
    {
        if(isDoorOpen) {
            if (desiredFloor <= maxCapacity && desiredFloor > 0) {
                available += desiredFloor;
                if (available < 0) {
                    available = 0;
                }
            }
        }
       return available;
    }

    public int getAvailableCapacity() {
        return available;
    }

}
