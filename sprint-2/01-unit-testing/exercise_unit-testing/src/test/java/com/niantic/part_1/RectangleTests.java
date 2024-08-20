package com.niantic.part_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RectangleTests
{

    private Rectangle rectangle;

    // the parameterless constructor should create a rectangle of size (5 x 5)
    // the area of the rectangle should be calculated correctly (width x height)
    // the perimeter of the rectangle should be calculated correct (2x width) + (2x height)

    @Test
    public void calculateRectangle_shouldReturn_areaAndPerimeter() {

        // arrange
        Rectangle rectangle = new Rectangle();
        int expectedArea = 25;
        int actualArea = rectangle.getArea();
        int expectedPerimeter = 20;
        int actualPerimeter = rectangle.getPerimeter();

        assertEquals(expectedArea, actualArea, "Because the width x height is 5 x 5");
        assertEquals(expectedPerimeter, actualPerimeter, "Because the perimeter is (width x height) x 2");

    }

    // width and height must be positive
    // if either the width or height are zero or less when the area it should return 0
    // if either the width or height are zero or less when the perimeter it should return 0

    @Test
    public void valuesAreZero_shouldReturn_Zero() {

        Rectangle rectangle = new Rectangle(0, 5);
        int area = rectangle.getArea();
        boolean zeroValuesArea = (area <= 0);
        int perimeter = rectangle.getPerimeter();
        boolean zeroValuesRectangle = (perimeter <= 0);

        assertTrue(zeroValuesRectangle, "Because the width and height is less than or equal to 0");
        assertTrue(zeroValuesArea, "Because the width and height is less than or equal to 0");
        System.out.println("Is the perimeter zero? " + zeroValuesRectangle);
        System.out.println("Is the area zero? " + zeroValuesArea);

    }


}