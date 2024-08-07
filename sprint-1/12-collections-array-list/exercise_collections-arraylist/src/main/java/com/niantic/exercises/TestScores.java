package com.niantic.exercises;

import com.niantic.models.TestScore;

import java.sql.Array;
import java.util.ArrayList;

public class TestScores
{

    /*
    1.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a test - return all scores for the
        requested tests.
     */
    public ArrayList<TestScore> getScoresByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> scores = new ArrayList<>();
        for (TestScore testScore : testScores) {
            if (testScore.getTestName().equals(testName)) {
                scores.add(testScore);
            }
        }
        return scores;
    }

    /*
    2.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a student - return all scores for the
        requested student.
     */
    public ArrayList<TestScore> getScoresByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> studentScores = new ArrayList<>();
        for (TestScore testScore : testScores) {
            if (testScore.getStudentName().equals(student)) {
                studentScores.add(testScore);
            }
        }
        return studentScores;
    }

    /*
    3.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score.
     */
    public int getHighestScore(ArrayList<TestScore> testScores)
    {
        var highestTestScore = testScores.getFirst().getScore();
        for (TestScore testScore : testScores) {
            if (testScore.getScore() > highestTestScore) {
                highestTestScore = testScore.getScore();
            }
        }
        return highestTestScore;
    }

    /*
    4.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getLowestScore(ArrayList<TestScore> testScores)
    {
        var lowestTestScore = testScores.getFirst().getScore();
        for (TestScore testScore : testScores) {
            if (testScore.getScore() < lowestTestScore) {
                lowestTestScore = testScore.getScore();
            }
        }
        return lowestTestScore;
    }

    /*
    5.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getAverageScore(ArrayList<TestScore> testScores)
    {
        int totalAverage = 0;
        for (TestScore testScore : testScores) {
            totalAverage += testScore.getScore();

        }
        return totalAverage / testScores.size();
    }

    /*
    6.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified test name.
     */
    public int getHighestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int highestTestScore = Integer.MIN_VALUE;
        for (TestScore testScore : testScores)
        {
            if (testScore.getTestName().equals(testName)) {
                if (testScore.getScore() > highestTestScore) {
                    highestTestScore = testScore.getScore();
                }
            }
        }
        return highestTestScore;
    }

    /*
    7.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified test name.
     */
    public int getLowestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int lowestTestScore = Integer.MAX_VALUE;
        for (TestScore testScore : testScores) {
            if (testScore.getTestName().equals(testName)) {
                if (testScore.getScore() < lowestTestScore) {
                    lowestTestScore = testScore.getScore();
                }
            }
        }
        return lowestTestScore;
    }

    /*
    8.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified test name.
     */
    public int getAverageScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        int totalAverageScore = 0;
        int count = 0;
        for (TestScore testScore : testScores) {
            if (testScore.getTestName().equals(testName)) {
                totalAverageScore += testScore.getScore();
                count++;
            }
        }
        return totalAverageScore / count;
    }

    /*
    9.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified student.
     */
    public int getHighestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        Integer highestStudentScore = Integer.MIN_VALUE;
        for (TestScore testScore : testScores) {
            if (testScore.getStudentName().equals(student)) {
                if (testScore.getScore() > highestStudentScore) {
                    highestStudentScore = testScore.getScore();
                }
            }
        }
        return highestStudentScore;
    }

    /*
    10.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified student.
     */
    public int getLowestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        Integer lowestStudentScore = Integer.MAX_VALUE;
        for (TestScore testScore : testScores) {
            if (testScore.getStudentName().equals(student)) {
                if (testScore.getScore() < lowestStudentScore) {
                    lowestStudentScore = testScore.getScore();
                }
            }
        }
        return lowestStudentScore;
    }

    /*
    11.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified student.
     */
    public int getAverageScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        Integer averageStudentScore = 0;
        Integer count = 0;
        for (TestScore testScore : testScores) {
            if (testScore.getStudentName().equals(student)) {
                averageStudentScore += testScore.getScore();
                count++;
            }
        }
        return averageStudentScore / count;
    }
}
