package com.niantic.services;

import com.niantic.models.Category;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    public CategoryDao()
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

    public ArrayList<Category> getAllCategories()
    {

        ArrayList<Category> categories = new ArrayList<>();

        String sql = """
                SELECT category_id
                , category_name
                , description
                FROM categories;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {

           int categoryId = row.getInt("category_id");
           String categoryName = row.getString("category_name");
           String description = row.getString("description");

           // has to match how constructor with parameters is formatted
           Category category = new Category(categoryId, categoryName, description);


           categories.add(category);


        }

        return categories;

    }

    public Category getCategoryByName(String name)
    {

        String sql = """
                SELECT category_id
                , category_name
                , description
                FROM categories
                WHERE name = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {

            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            return new Category(categoryId, categoryName, description);

        }
        return null;

    }

    public void addCategory(Category category)
    {

        String sql = "INSERT INTO categories (category_name, description) VALUES (?, ?);";

        jdbcTemplate.update(sql,
                category.getName(),
                category.getDescription());

    }


}
