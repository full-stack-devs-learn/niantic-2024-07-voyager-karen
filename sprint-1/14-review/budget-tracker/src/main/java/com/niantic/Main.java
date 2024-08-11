package com.niantic;

import com.niantic.application.BudgetTracker;
import com.niantic.services.CategoryDao;
import com.niantic.services.SubCategoryDao;
import com.niantic.services.TransactionDao;
import com.niantic.services.UserDao;
import com.niantic.services.VendorDao;

public class Main
{
    public static void main(String[] args)
    {
        BudgetTracker app = new BudgetTracker();
        app.run();
    }
}