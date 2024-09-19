package com.niantic.services;

import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.apache.commons.dbcp2.BasicDataSource;

public class MySqlProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public MySqlProductDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";

        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();

        String sql = """
                SELECT product_id, product_name, category_id
                FROM products
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while(row.next()) {

            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            int categoryId = row.getInt("category_id");

            Product product = new Product(productId, productName, categoryId);

            products.add(product);

        }

        return products;

    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        String sql = """
                SELECT product_id, product_name, category_id
                FROM products
                WHERE category_id = ?
                """;

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, categoryId);

        List<Product> products = new ArrayList<>();

        while (rowSet.next()) {
            Product product = new Product(
                    rowSet.getInt("product_id"),
                    rowSet.getString("product_name"),
                    rowSet.getInt("category_id")
            );
            products.add(product);
        }

        return products;
    }
}
