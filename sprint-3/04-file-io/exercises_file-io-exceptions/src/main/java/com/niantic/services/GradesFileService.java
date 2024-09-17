package com.niantic.services;

import com.niantic.models.Assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradesFileService implements GradesService
{

    @Override
    public String[] getFileNames()
    {
        File folder = new File("files");
        String[] files = folder.list();

        return files;
    }

    @Override
    public List<Assignment> getAssignments(String fileName) {
        List<Assignment> assignments = new ArrayList<>();
        String filePath = "files/" + fileName;
        File file = new File(filePath);

        try (Scanner reader = new Scanner(file)) {

            if (reader.hasNextLine()) {
                reader.nextLine();
            }

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] columns = line.split(",");

                if (columns.length == 5) {
                    int number = Integer.parseInt(columns[0]);
                    String firstName = columns[1];
                    String lastName = columns[2];
                    String assignmentName = columns[3];
                    int score = Integer.parseInt(columns[4]);

                    Assignment assignment = new Assignment(number, firstName, lastName, assignmentName, score);
                    assignments.add(assignment);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames) {
        List<Assignment> allAssignments = new ArrayList<>();

        for (String fileName : fileNames) {
            allAssignments.addAll(getAssignments(fileName));
        }

        return allAssignments;
    }
}
