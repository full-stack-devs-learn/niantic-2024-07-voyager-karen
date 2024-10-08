package com.niantic.models;

import java.time.LocalDate;


public class Transaction {

    private int transactionId;
    private int userId;
    private int subCategoryId;
    private int vendorId;
    private LocalDate date;
    private double amount;
    private String notes;

    public Transaction(){

    }

    public Transaction(int transactionId, int userId, int subCategoryId, int vendorId, LocalDate date, double amount, String notes) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.subCategoryId = subCategoryId;
        this.vendorId = vendorId;
        this.date = date;
        this.amount = amount;
        this.notes = notes;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return String.format("%2d: User ID - %s, SubCategory ID - %s, Vendor ID - %s, Amount - %.2f, Notes - %s\n",
                transactionId, userId, subCategoryId, vendorId, amount, notes);
    }

}
