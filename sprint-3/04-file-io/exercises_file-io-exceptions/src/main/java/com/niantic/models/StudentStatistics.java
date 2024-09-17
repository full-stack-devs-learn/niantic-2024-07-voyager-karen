package com.niantic.models;


import java.util.List;

public class StudentStatistics {

    private String fistName;
    private String lastName;
    private List<Assignment> assignments;

    public StudentStatistics(String fistName, String lastName, List<Assignment> assignments) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.assignments = assignments;
    }

    public String getFistName() {
        return fistName;
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
