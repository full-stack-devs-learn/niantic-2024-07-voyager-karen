package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.StudentStatistics;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.services.LoggingService;
import com.niantic.ui.UserInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();
    private final UserInput ui = new UserInput();

    private final LoggingService errorLogger = new LoggingService("errors");
    private final LoggingService appLogger = new LoggingService("application");

    public void run()
    {
        while(true)
        {
            int choice = UserInput.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    displayFileScores();
                    break;
                case 3:
                    displayStudentAverages();
                    break;
                case 4:
                    createStudentSummaryReport();
                    break;
                case 5:
                    createAllStudentsReport();
                    break;
                case 6:
                    displayAllStudentStatistics();
                    break;
                case 7:
                    displayAssignmentStatistics();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private String displayAllFiles() {

        appLogger.logMessage("Listing all files");
        String[] fileNames = gradesService.getFileNames();

        if (fileNames == null || fileNames.length == 0) {

            errorLogger.logMessage("No files found.");
            System.out.println("No files found.");
            return null;
        }

        System.out.println("Select a file:");

        for (int i = 0; i < fileNames.length; i++) {
            System.out.println((i + 1) + ". " + fileNames[i]);
        }

        int fileChoice = ui.getIntInput("Enter the number of the file: ") - 1;

        if (fileChoice >= 0 && fileChoice < fileNames.length) {
            return fileNames[fileChoice];
        } else {

            errorLogger.logMessage("Invalid choice");
            System.out.println("Invalid choice.");
            return null;
        }
    }


    private void displayFileScores() {
        String selectedFile = displayAllFiles();

        if (selectedFile != null) {
            List<Assignment> assignments = gradesService.getAssignments(selectedFile);

            if (!assignments.isEmpty()) {
                for (Assignment assignment : assignments) {
                    System.out.println(assignment.getNumber() + ". Name: " + assignment.getFirstName() + " " +
                            assignment.getLastName() + ", Subject: " + assignment.getAssignmentName() +
                            ", Score: " + assignment.getScore());
                }
            } else {
                System.out.println("No assignments found for this student.");
            }
        }
    }


    private void displayStudentAverages() {
        String selectedFile = displayAllFiles();

        if (selectedFile != null) {
            List<Assignment> assignments = gradesService.getAssignments(selectedFile);

            if (!assignments.isEmpty()) {
                String firstName = assignments.get(0).getFirstName();
                String lastName = assignments.get(0).getLastName();
                StudentStatistics stats = new StudentStatistics(firstName, lastName, assignments);


                System.out.println("Student Statistics:");
                System.out.println("Lowest Score: " + stats.getLowScore());
                System.out.println("Highest Score: " + stats.getHighScore());
                System.out.println("Average Score: " + String.format("%.2f", stats.getAverageScore()));
            } else {
                System.out.println("No assignments found for this student.");
            }
        }
    }


    public void createStudentSummaryReport() {
        String selectedFile = displayAllFiles();

        if (selectedFile != null) {
            List<Assignment> assignments = gradesService.getAssignments(selectedFile);

            if (!assignments.isEmpty()) {
                String firstName = assignments.get(0).getFirstName();
                String lastName = assignments.get(0).getLastName();
                StudentStatistics stats = new StudentStatistics(firstName, lastName, assignments);

                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String reportFileName = "reports/" + date + "_" + firstName.toLowerCase() + "_" + lastName.toLowerCase() + ".txt";

                try (FileWriter writer = new FileWriter(reportFileName)) {
                    writer.write(firstName + " " + lastName + "\n");
                    writer.write("-".repeat(40) + "\n");
                    writer.write(String.format("Low Score                          %.2f\n", stats.getLowScore()));
                    writer.write(String.format("High Score                         %.2f\n", stats.getHighScore()));
                    writer.write(String.format("Average Score                      %.2f\n", stats.getAverageScore()));

                    System.out.println("Summary report created: " + reportFileName);
                } catch (IOException e) {
                    System.out.println("Error writing to the report file: " + e.getMessage());
                }
            } else {
                System.out.println("No assignments found for this student.");
            }
        }
    }

    private void createAllStudentsReport() {

        String[] fileNames = gradesService.getFileNames();

        List<Assignment> allAssignments = gradesService.getAllAssignments(fileNames);

        // Calculate total students and assignments
        long totalStudents = allAssignments.stream()
                .map(assignment -> assignment.getFirstName() + " " + assignment.getLastName())
                .distinct()
                .count();

        int totalAssignments = allAssignments.size();

        // Calculate lowest, highest, average score
        double lowestScore = allAssignments.stream()
                .mapToDouble(Assignment::getScore)
                .min()
                .getAsDouble();

        double highestScore = allAssignments.stream()
                .mapToDouble(Assignment::getScore)
                .max()
                .getAsDouble();

        double averageScore = allAssignments.stream()
                .mapToDouble(Assignment::getScore)
                .average()
                .getAsDouble();

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


        String reportFileName = "reports/" + date + "_all_students.txt";


        try (FileWriter writer = new FileWriter(reportFileName)) {
            writer.write("All Assignments\n");
            writer.write("-".repeat(60) + "\n");
            writer.write(String.format("Total Students%47d\n", totalStudents));
            writer.write(String.format("Total Assignments%44d\n", totalAssignments));
            writer.write("-".repeat(60) + "\n");
            writer.write(String.format("Low Score%52.2f\n", lowestScore));
            writer.write(String.format("High Score%51.2f\n", highestScore));
            writer.write(String.format("Average Score%48.2f\n", averageScore));
            writer.write("-".repeat(60) + "\n");

            System.out.println("All students report created: " + reportFileName);
        } catch (IOException e) {
            System.out.println("Error writing to the report file: " + e.getMessage());
        }
    }




    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
    }

    private void displayAssignmentStatistics()
    {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
    }

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                        .replace("_", " ")
                        .substring(10);
    }
}
