package com.niantic.models;


import java.util.List;

public class StudentStatistics {

    private String firstName;
    private String lastName;
    private List<Assignment> assignments;

    public StudentStatistics(String firstName, String lastName, List<Assignment> assignments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.assignments = assignments;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public double getLowScore()
    {
        return assignments.stream()
                .mapToDouble(Assignment::getScore)
                .min()
                .getAsDouble();
    }

    public double getHighScore()
    {
        return assignments.stream()
                .mapToDouble(Assignment::getScore)
                .max()
                .getAsDouble();
    }

    public double getAverageScore()
    {
        return assignments.stream()
                .mapToDouble(Assignment::getScore)
                .average()
                .getAsDouble();
    }
}
