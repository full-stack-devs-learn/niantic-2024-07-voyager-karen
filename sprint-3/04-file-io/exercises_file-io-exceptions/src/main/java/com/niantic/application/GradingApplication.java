package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();

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
                    displayAllStudentStatistics();
                    break;
                case 5:
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

    private void displayAllFiles()
    {
        File files = new File("files/");

        if(files.isDirectory()) {
            String[] fileNames = files.list();
            if(fileNames != null) {
                System.out.println("Student File Names:");
                for(String fileName : fileNames) {
                    System.out.println(fileName);
                }
            }
        }
    }


    private void displayFileScores()
    {

        File files = new File("files/");
        Scanner input = new Scanner(System.in);

        if(files.isDirectory()) {
            String[] fileNames = files.list();
            if(fileNames != null && fileNames.length > 0) {
                System.out.println("Select file to view student scores:");

                for(int i = 0; i < fileNames.length; i++) {
                    System.out.println((i + 1) + ". " + fileNames[i]);
                }

                System.out.print("Enter the number of the file: ");
                int fileChoice = input.nextInt();

                if(fileChoice >= 1 && fileChoice <= fileNames.length) {
                    String selectedFile = fileNames[fileChoice - 1];
                    System.out.println("File you selected: " + selectedFile);

                    String filePath = "files/" + selectedFile;
                    File file = new File(filePath);

                    try(Scanner reader = new Scanner(file)) {

                        reader.nextLine();

                        while(reader.hasNextLine()) {

                            String line = reader.nextLine();
                            var columns = line.split(",");

                            int assignmentNum = Integer.parseInt(columns[0]);
                            String firstName = columns[1];
                            String lastName = columns[2];
                            String assignment = columns[3];
                            int score = Integer.parseInt(columns[4]);

                            System.out.println(assignmentNum + ". Name: " + firstName + " " + lastName + ", " +
                                    "Subject: " + assignment + ", " + "Score: " + score);
                        }

                    }  catch (FileNotFoundException e) {
                        System.out.println("File not found: " + filePath);
                    }
                }

            }
        }
    }


    private void displayStudentAverages() {
        File files = new File("files/");
        Scanner input = new Scanner(System.in);

        if (files.isDirectory()) {
            String[] fileNames = files.list();
            if (fileNames != null && fileNames.length > 0) {
                System.out.println("Select a file to view student statistics:");

                for (int i = 0; i < fileNames.length; i++) {
                    System.out.println((i + 1) + ". " + fileNames[i]);
                }

                System.out.print("Enter the number of the file: ");
                int fileChoice = input.nextInt();

                if (fileChoice >= 1 && fileChoice <= fileNames.length) {
                    String selectedFile = fileNames[fileChoice - 1];
                    System.out.println("File you selected: " + selectedFile);

                    String filePath = "files/" + selectedFile;
                    File file = new File(filePath);

                    try (Scanner reader = new Scanner(file)) {
                        reader.nextLine();

                        int totalScore = 0;
                        int numberOfAssignments = 0;
                        int lowScore = Integer.MAX_VALUE;
                        int highScore = Integer.MIN_VALUE;

                        while (reader.hasNextLine()) {
                            String line = reader.nextLine();
                            var columns = line.split(",");

                            if (columns.length == 5) {
                                int score = Integer.parseInt(columns[4]);

                                totalScore += score;
                                numberOfAssignments++;

                                if (score < lowScore) {
                                    lowScore = score;
                                }
                                if (score > highScore) {
                                    highScore = score;
                                }
                            }
                        }

                        if (numberOfAssignments > 0) {
                            double averageScore = (double) totalScore / numberOfAssignments;
                            System.out.println("Student Statistics:");
                            System.out.println("Lowest Score: " + lowScore);
                            System.out.println("Highest Score: " + highScore);
                            System.out.println("Average Score: " + String.format("%.2f", averageScore));
                        }

                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                }
            }
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
