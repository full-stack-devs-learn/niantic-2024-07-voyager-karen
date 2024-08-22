package com.niantic.part_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RectangleTests
{

    private Rectangle rectangle;

    // the parameterless constructor should create a rectangle of size (5 x 5)

    @Test
    public void parameterlessConstructor_shouldCreateRectangleOfSize5x5() {

        // arrange & act
        Rectangle rectangle = new Rectangle();
        int expectedWidth = 5;
        int expectedHeight = 5;

        // assert
        assertEquals(expectedWidth, rectangle.getWidth(), "The width should be 5 by default.");
        assertEquals(expectedHeight, rectangle.getHeight(), "The height should be 5 by default.");
    }

    // the area of the rectangle should be calculated correctly (width x height)
    @Test
    public void calculateRectangle_shouldReturn_CorrectArea() {


        Rectangle rectangle = new Rectangle();
        int expectedArea = 25;
        int actualArea = rectangle.getArea();


        assertEquals(expectedArea, actualArea, "Because the width x height is 5 x 5");
    }

    // the perimeter of the rectangle should be calculated correct (2x width) + (2x height)
    @Test
    public void calculateRectangle_shouldReturn_CorrectPerimeter() {


        Rectangle rectangle = new Rectangle();
        int expectedPerimeter = 20;
        int actualPerimeter = rectangle.getPerimeter();


        assertEquals(expectedPerimeter, actualPerimeter, "Because the perimeter is 2 x (width + height) when width and height are 5");
    }

    // width and height must be positive
    // if either the width or height are zero or less when the area it should return 0

    @Test
    public void areaWithNonPositiveValues_shouldReturn_Zero() {

        Rectangle rectangle = new Rectangle(-4, 5);
        int area = rectangle.getArea();
        boolean zeroValuesArea = (area <= 0);

        assertTrue(zeroValuesArea, "Because the width or height is less than or equal to 0");
        System.out.println("Is the area zero? " + zeroValuesArea);
    }

    // if either the width or height are zero or less when the perimeter it should return 0
    @Test
    public void perimeterWithNonPositiveValues_shouldReturn_Zero() {

        Rectangle rectangle = new Rectangle(0, 5);
        int perimeter = rectangle.getPerimeter();
        boolean zeroValuesRectangle = (perimeter <= 0);

        assertTrue(zeroValuesRectangle, "Because the width or height is less than or equal to 0");
        System.out.println("Is the perimeter zero? " + zeroValuesRectangle);
    }



}