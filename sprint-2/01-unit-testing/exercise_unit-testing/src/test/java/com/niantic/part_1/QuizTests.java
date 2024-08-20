package com.niantic.part_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuizTests
{

    private Quiz quiz;

    // Ensure that getPercentage() calculates the correct integer value using score and possiblePoints
    @Test
    public void divide_shouldReturn_theQuotientOfNumbers()
    {

        Quiz quiz = new Quiz(80, 100, "John Doe");
        int expectedPercent = 80;
        int actualPercent = quiz.getPercent();

        assertEquals(expectedPercent, actualPercent, "Because it should have calculated 80 / 100");

    }
    // Ensure that getLetterGrade() returns the correct grade based on the quiz percent

    @Test
    public void percentNum_shouldReturn_letterGrade()
    {

        Quiz quiz = new Quiz(100, 100, "Jane Doe");
        String expectedGrade = "A";
        String actualGrade = quiz.getLetterGrade();

        assertEquals(expectedGrade, actualGrade, "Because the percent is greater than 90");

    }

    // possible points must be positive
    // score must be positive
    @Test
    public void negativeValue_shouldReturn_zero()
    {
        Quiz quiz = new Quiz(-3, -100, "Lori");
        int points = quiz.getPossiblePoints();
        int score = quiz.getScore();
        boolean negativePoints = (points < 0);
        boolean negativeScore = (score < 0);

        assertTrue(negativePoints, "Because the possible points value is a negative number");
        assertTrue(negativeScore,"Because the score value is a negative number");

    }



}