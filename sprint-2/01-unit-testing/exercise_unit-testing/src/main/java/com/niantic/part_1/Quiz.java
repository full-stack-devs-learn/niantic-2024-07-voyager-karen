package com.niantic.part_1;

public class Quiz
{
    private int score;
    private int possiblePoints;
    private String studentName;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPossiblePoints() {
        return possiblePoints;
    }

    public void setPossiblePoints(int possiblePoints) {
        this.possiblePoints = possiblePoints;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Quiz(int score, int possiblePoints, String studentName)
    {
        this.score = score;
        this.possiblePoints = possiblePoints;
        this.studentName = studentName;
    }

    public Quiz() {

    }

    public int getPercent() {
        if (possiblePoints < 0 || score < 0) {
            return 0;
        }
        return (int) ((double) score / possiblePoints * 100);
    }


    public String getLetterGrade()
    {
        int percent = getPercent();

        if(percent >= 90) return "A";
        else if(percent >= 80) return "B";
        else if(percent >= 70) return "C";
        else if(percent >= 60) return "D";
        else return "F";
    }
}
