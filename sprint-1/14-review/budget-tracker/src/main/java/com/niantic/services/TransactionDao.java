package com.niantic.services;

import com.niantic.models.Transaction;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Date;

public class TransactionDao {

    private final JdbcTemplate jdbcTemplate;

    public TransactionDao()
    {

        String databaseUrl = "jdbc:mysql://localhost:3306/newBudget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource(){{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Transaction> getAllTransactions() {

        ArrayList<Transaction> transactions = new ArrayList<>();

        String sql = """
                SELECT transaction_id
                , user_id
                , sub_category_id
                , vendor_id
                , transaction_date
                , amount
                , notes
                FROM transactions;
                """;

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {

            int transactionId = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int subCategoryId = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            double amount = row.getDouble("amount");
            String notes = row.getString("notes");

            LocalDate transactionDate = null;
            Date date = row.getDate("transaction_date");
            if(date != null)
            {
                transactionDate = ((java.sql.Date) date).toLocalDate();
            }
//
//            LocalDate transactionDate = null;
//            if (row.getDate("transaction_date") != null)
//            {
//                transactionDate = row.getDate("transaction_date").toLocalDate();
//            }

            var allTransactions = new Transaction(transactionId, userId, subCategoryId, vendorId, transactionDate ,amount, notes);
            transactions.add(allTransactions);

        }

     return transactions;

    }

    public ArrayList<Transaction> getTransactionByUser(int userId)
    {

        ArrayList<Transaction> userTransactions = new ArrayList<>();

        String sql = """
                SELECT transaction_id
                , user_id
                , transaction_date
                , amount
                FROM transactions
                Where user_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, userId);

        // write loop here
        while(row.next()) {

            int transactionID = row.getInt("transaction_id");
            int userID = row.getInt("user_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");

            var transactionsByUser = new Transaction();
            transactionsByUser.setTransactionId(transactionID);
            transactionsByUser.setUserId(userID);
            transactionsByUser.setDate(transactionDate);
            transactionsByUser.setAmount(amount);

            userTransactions.add(transactionsByUser);

            return userTransactions;

        }

        return null;

    }

    public ArrayList<Transaction> getTransactionByMonth(int month)
    {

        ArrayList<Transaction> transactionsByMonth = new ArrayList<>();

        String sql = """
                SELECT transaction_id
                , sub_category_id
                , vendor_id
                , transaction_date
                , amount
                FROM transactions
                WHERE month = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, month);

        while(row.next())
        {

            int transactionID = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");

            var transactionInfo = new Transaction();
            transactionInfo.setTransactionId(transactionID);
            transactionInfo.setUserId(userId);
            transactionInfo.setVendorId(vendorId);
            transactionInfo.setDate(transactionDate);
            transactionInfo.setAmount(amount);

            transactionsByMonth.add(transactionInfo);

            return transactionsByMonth;

        }

        return null;

    }

    public ArrayList<Transaction> getTransactionByYear(int year)
    {

        ArrayList<Transaction> transactionsByYear = new ArrayList<>();

        String sql = """
                SELECT transaction_id
                , sub_category_id
                , vendor_id
                , transaction_date
                , amount
                FROM transactions
                WHERE year = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, year);

        while(row.next())
        {

            int transactionID = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");

            var transactionInfo = new Transaction();
            transactionInfo.setTransactionId(transactionID);
            transactionInfo.setUserId(userId);
            transactionInfo.setVendorId(vendorId);
            transactionInfo.setDate(transactionDate);
            transactionInfo.setAmount(amount);

            transactionsByYear.add(transactionInfo);

            return transactionsByYear;

        }

        return null;


    }

    public ArrayList<Transaction> getTransactionBySubCategory(int subCategoryId)
    {

        ArrayList<Transaction> transactionsBySubCategory = new ArrayList<>();

        String sql = """
                SELECT transaction_id
                , sub_category_id
                , vendor_id
                , transaction_date
                , amount
                FROM transactions
                WHERE subCategoryId = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, subCategoryId);

        while(row.next())

        {

            int transactionID = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int sub_category_id = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");

            var transactionInfo = new Transaction();
            transactionInfo.setTransactionId(transactionID);
            transactionInfo.setUserId(userId);
            transactionInfo.setSubCategoryId(sub_category_id);
            transactionInfo.setVendorId(vendorId);
            transactionInfo.setDate(transactionDate);
            transactionInfo.setAmount(amount);

            transactionsBySubCategory.add(transactionInfo);

            return transactionsBySubCategory;

        }

        return null;

    }


    // get transaction by category id
    public ArrayList<Transaction> getTransactionByCategory(int categoryId)
    {

        ArrayList<Transaction> transactionsByCategory = new ArrayList<>();

        String sql = """
                SELECT transaction_id
                , sub_category_id
                , vendor_id
                , transaction_date
                , amount
                FROM transactions
                WHERE categoryId = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, categoryId);


        while(row.next())

        {

            int transactionID = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int sub_category_id = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");

            var transactionInfo = new Transaction();
            transactionInfo.setTransactionId(transactionID);
            transactionInfo.setUserId(userId);
            transactionInfo.setSubCategoryId(sub_category_id);
            transactionInfo.setVendorId(vendorId);
            transactionInfo.setDate(transactionDate);
            transactionInfo.setAmount(amount);

            transactionsByCategory.add(transactionInfo);

            return transactionsByCategory;

        }

        return null;

    }

    public Transaction getTransactionById(int categoryId)
    {
        String sql = """
                SELECT transaction_id
                , sub_category_id
                , vendor_id
                , transaction_date
                , amount
                , notes
                FROM transactions
                WHERE categoryId = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, categoryId);

        if(row.next())
        {

            int transactionID = row.getInt("transaction_id");
            int userId = row.getInt("user_id");
            int sub_category_id = row.getInt("sub_category_id");
            int vendorId = row.getInt("vendor_id");
            LocalDate transactionDate = row.getDate("transaction_date").toLocalDate();
            double amount = row.getDouble("amount");
            String notes = row.getString("notes");

            return new Transaction(transactionID, userId, sub_category_id, vendorId, transactionDate, amount, notes);

        }

        return null;

    }

    public void addTransaction(Transaction transaction)
    {

        String sql = "INSERT INTO transactions (transaction_date, amount, notes) VALUES (?,?);";

        jdbcTemplate.update(sql,
                transaction.getDate(),
                transaction.getAmount(),
                transaction.getNotes());

    }

    public void updateTransaction(Transaction transaction)
    {

        String sql = """
                UPDATE transactions
                SET transaction_date = ?
                    , amount = ?
                    , notes = ?
                WHERE transaction_id = ?;
                """;

    }

    public void deleteTransaction(int id)
    {

        String sql = "DELETE FROM transactions WHERE transaction_id = ?;";

        jdbcTemplate.update(sql, id);

    }


}
