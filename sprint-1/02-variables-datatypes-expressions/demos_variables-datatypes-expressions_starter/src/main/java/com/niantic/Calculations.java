package com.niantic;

public class Calculations
{
    public static void main(String[] args)
    {
        int numberOfStudents = 4;
        int numberofDonuts = 22;

        int donutsPerStudent = numberOfStudents / numberOfStudents;
        int remainingDonuts = numberofDonuts % numberOfStudents;
        double donutsPerStudentDouble = numberofDonuts / numberOfStudents;

        System.out.println("Number of donuts per students");
        System.out.println("Total donuts: " + numberofDonuts);
        System.out.println("Total students: " + donutsPerStudent);
        System.out.println("Donuts per student: " + donutsPerStudent);
        System.out.println();
        System.out.println("Donuts per second (double): " + donutsPerStudentDouble);

    }
}
