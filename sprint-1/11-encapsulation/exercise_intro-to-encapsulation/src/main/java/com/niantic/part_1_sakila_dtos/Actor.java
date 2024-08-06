package com.niantic.part_1_sakila_dtos;

public class Actor
{

    private String firstName;
    private String lastName;
    private int actorID;

    public Actor()
    {

    }

    public Actor(int actorID, String firstName, String lastName)
    {
        this.actorID = actorID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getActorId()
    {
        return actorID;
    }

    public void setActorId(int actorID)
    {
        this.actorID = actorID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }


}
