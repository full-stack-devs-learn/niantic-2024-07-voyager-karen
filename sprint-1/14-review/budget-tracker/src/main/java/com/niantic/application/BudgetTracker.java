package com.niantic.application;

import com.niantic.models.Category;
import com.niantic.services.CategoryDao;
import com.niantic.models.SubCategory;
import com.niantic.services.SubCategoryDao;
import com.niantic.models.Transaction;
import com.niantic.services.TransactionDao;
import com.niantic.models.User;
import com.niantic.services.UserDao;
import com.niantic.models.Vendor;
import com.niantic.services.VendorDao;


import java.util.Scanner;

public class BudgetTracker
{
    Scanner userInput = new Scanner(System.in);

    CategoryDao categoryDao = new CategoryDao();
    SubCategoryDao subCategoryDao = new SubCategoryDao();
    TransactionDao transactionDao = new TransactionDao();
    UserDao userDao = new UserDao();
    VendorDao vendorDao = new VendorDao();

    public void run()
    {

        while(true)
        {
            int choice = homeScreenSelection();
            switch(choice)
            {
                case 1:
                    System.out.println("add transaction");
                    addTransactions();
                    break;
                case 2:
                    System.out.println("reports");
                    viewReports();
                    break;
                case 3:
                    System.out.println("add user");
                    addUser();
                    break;
                case 4:
                    System.out.println("add category");
                    addCategory();
                    break;
                case 5:
                    System.out.println("add sub category");
                    addSubCategory();
                    break;
                case 6:
                    System.out.println("add vendor");
                    addVendor();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Thank you for using Northwind!");
                    System.out.println("Goodbye");
                    System.out.println();
                    System.exit(0);
                default:
                    System.out.println("invalid selection");
                    break;
            }
        }

    }

    private int homeScreenSelection()
    {
        System.out.println();
        System.out.println("Budget Tracker");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Add Transaction");
        System.out.println("  2) Reports");
        System.out.println("  3) Add User");
        System.out.println("  4) Add Category");
        System.out.println("  5) Add Sub Category");
        System.out.println("  6) Add Vendor");
        System.out.println("  0) Quit");
        System.out.println();

        System.out.print("Enter an option: ");
        return Integer.parseInt(userInput.nextLine());
    }


    private void viewReports() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select the type of report you want to view:");
            System.out.println("1. View All Categories");
            System.out.println("2. View All Sub-Categories");
            System.out.println("3. View All Transactions");
            System.out.println("4. View All Users");
            System.out.println("5. View All Vendors");
            System.out.println("0. Return to Main Menu");

            System.out.print("Enter an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayAllCategories();
                    break;
                case 2:
                    displayAllSubCategories();
                    break;
                case 3:
                    displayAllTransactions();
                    break;
                case 4:
                    displayAllUsers();
                    break;
                case 5:
                    displayAllVendors();
                    break;
                case 0:
                    homeScreenSelection();
                default:
                    System.out.println("That was an invalid selection, please select from the available options.");
                    break;
            }
        }
    }

    private void displayAllCategories()
    {
        var categories = categoryDao.getAllCategories();

        System.out.println();
        System.out.println("All Categories");
        System.out.println("-".repeat(100));

        if (categories.isEmpty()) {
            System.out.println("No categories found.");
        } else {
            for(Category category : categories) {
                System.out.println(category);
            }
        }

        viewReports();
    }

    private void displayAllSubCategories()
    {
        var subCategories = subCategoryDao.getSubCategory();

        System.out.println();
        System.out.println("All SubCategories");
        System.out.println("-".repeat(100));

        if (subCategories.isEmpty()) {
            System.out.println("No Sub-categories found.");
        } else {
            for(SubCategory subCategory : subCategories) {
                System.out.println(subCategory);
            }
        }

        viewReports();
    }

    private void displayAllTransactions()
    {
        var transactions = transactionDao.getAllTransactions();

        System.out.println();
        System.out.println("All Transactions");
        System.out.println("-".repeat(100));

        if (transactions.isEmpty()) {
            System.out.println("No Transactions found.");
        } else {
            for(Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        }

        viewReports();
    }

    private void displayAllUsers()
    {
        var users = userDao.getAllUsers();

        System.out.println();
        System.out.println("All Users");
        System.out.println("-".repeat(100));

        if (users.isEmpty()) {
            System.out.println("No Users Found.");
        } else {
            for(User user : users) {
                System.out.println(user);
            }
        }

        viewReports();
    }

    private void displayAllVendors()
    {
        var vendors = vendorDao.getAllVendors();

        System.out.println();
        System.out.println("All Vendors");
        System.out.print("-".repeat(100));

        if (vendors.isEmpty()) {
            System.out.println("No Vendors Found.");
        } else {
            for (Vendor vendor : vendors) {
                System.out.println(vendor);
            }
        }

        viewReports();
    }

    private void addTransactions() {
        System.out.println();
        System.out.println("Add Transaction");
        System.out.println("-".repeat(100));

        double amount = getUserDouble("Enter amount: ");
        String notes = getUserString("Enter any notes for the transaction: ");
        System.out.println();

        var transaction = new Transaction();
        {{
            transaction.setAmount(amount);
            transaction.setNotes(notes);
        }}
        transactionDao.addTransaction(transaction);

        System.out.println(String.format("%.2f has been added.", amount));

        displayAllTransactions();

    }

    private void addUser() {
        System.out.println();
        System.out.println("Add User");
        System.out.println("-".repeat(100));

        String name = getUserString("Enter username: ");
        String firstName = getUserString("Enter first name: ");
        String lastName = getUserString("Enter last name: ");
        String phone = getUserString("Enter phone number: ");
        String email = getUserString("Enter email address: ");
        System.out.println();

        var user = new User();
        {{
            user.setUserName(name);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhone(phone);
            user.setEmail(email);
        }};

        userDao.addUser(user);

        System.out.println(String.format("%s has been added.", name));

        displayAllUsers();

    }

    private void addCategory() {

        System.out.println();
        System.out.println("Add Category");
        System.out.println("-".repeat(100));

        String name = getUserString("Enter category name: ");
        String description = getUserString("Enter category description: ");
        System.out.println();

        var category = new Category();
        {{
            category.setName(name);
            category.setDescription(description);
        }};

        categoryDao.addCategory(category);

        System.out.println(String.format("%s has been added.", name));

        displayAllCategories();

    }

    private void addSubCategory() {

        System.out.println();
        System.out.println("Add SubCategory");
        System.out.println("-".repeat(100));

        String name = getUserString("Enter sub-category name: ");
        String description = getUserString("Enter sub-category description: ");
        System.out.println();

        var subCategory = new SubCategory();
        {{
            subCategory.setName(name);
            subCategory.setDescription(description);
        }};

        subCategoryDao.addSubCategory(subCategory);

        System.out.println(String.format("%s has been added.", name));

        displayAllSubCategories();

    }

    private void addVendor() {

        System.out.println();
        System.out.println("Add Vendor");
        System.out.println("-".repeat(100));

        String name = getUserString("Enter vendor name: ");
        String website = getUserString("Enter vendor website: ");
        System.out.println();

        var vendor = new Vendor();
        {{
            vendor.setName(name);
            vendor.setWebsite(website);
        }};

        vendorDao.addVendor(vendor);

        System.out.println(String.format("%s has been added.", name));

        displayAllVendors();

    }

    private String getUserString(String message)
    {
        System.out.print(message);
        return userInput.nextLine();
    }

    private int getUserInt(String message)
    {
        return Integer.parseInt(getUserString(message));
    }

    private double getUserDouble(String message)
    {
        return Double.parseDouble(getUserString(message));
    }


}
