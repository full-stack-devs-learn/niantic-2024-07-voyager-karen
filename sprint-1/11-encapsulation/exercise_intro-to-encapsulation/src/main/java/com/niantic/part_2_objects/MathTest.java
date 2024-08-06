package com.niantic.part_2_objects;

public class MathTest
{
    private int score;
    private int possiblePoints;
    private String studentName;

    public MathTest(int possiblePoints, String studentName)
    {
        this.possiblePoints = possiblePoints;
        this.studentName = studentName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPossiblePoints() {
        return possiblePoints;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getPercent() {
        return (score * possiblePoints) / 100;
    }

    public String getLetterGrade()
    {

        if (getPercent() >= 90) {
            return "A";
        } else if (getPercent() >= 80) {
            return "B";
        } else if (getPercent() >= 70) {
            return "C";
        } else if (getPercent() >= 60) {
            return "D";
        } else {
            return "F";
        }

    }


}
