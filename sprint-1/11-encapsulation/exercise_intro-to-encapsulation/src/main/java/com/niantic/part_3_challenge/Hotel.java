package com.niantic.part_3_challenge;

public class Hotel
{
    private int numberOfRooms;
    private int numberOfSuites;
    private int bookedRooms;
    private int bookedSuites;

    public Hotel(int numberOfRooms, int numberOfSuites)
    {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
    }

    public Hotel(int numberOfRooms, int numberOfSuites, int bookedRooms, int bookedSuites)
    {
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedRooms = bookedRooms;
        this.bookedSuites = bookedSuites;
    }

    public int getNumberOfRooms()
    {
        return numberOfRooms;
    }

    public int getNumberOfSuites()
    {
        return numberOfSuites;
    }

    public int getBookedRooms()
    {
        return bookedRooms;
    }

    public int getBookedSuites()
    {
        return bookedSuites;
    }

    public int getAvailableRooms()
    {
        return numberOfRooms - bookedRooms;
    }

    public int getAvailableSuites()
    {
        return numberOfSuites - bookedSuites;
    }

    public boolean makeReservation(int numberOfRooms, boolean isSuite)
    {
        if (isSuite && getAvailableSuites() != 0)
        {
            bookedSuites = getAvailableSuites() + numberOfRooms;
            return true;
        }
        if (!isSuite && getAvailableRooms() != 0) {
            bookedRooms = getAvailableRooms() + numberOfRooms;
            return true;
        }
        else
        {
            return false;
        }
    }
}
