package com.niantic.services;

import com.niantic.models.Product;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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
                SELECT product_id, product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued
                FROM products
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while (row.next()) {
            Product product = new Product(
                    row.getInt("product_id"),
                    row.getString("product_name"),
                    row.getInt("supplier_id"),
                    row.getInt("category_id"),
                    row.getString("quantity_per_unit"),
                    row.getDouble("unit_price"),
                    row.getInt("units_in_stock"),
                    row.getInt("units_on_order"),
                    row.getInt("reorder_level"),
                    row.getBoolean("discontinued")
            );
            products.add(product);
        }

        return products;
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        String sql = """
                SELECT product_id, product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued
                FROM products
                WHERE category_id = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        List<Product> products = new ArrayList<>();

        while (row.next()) {
            Product product = new Product(
                    row.getInt("product_id"),
                    row.getString("product_name"),
                    row.getInt("supplier_id"),
                    row.getInt("category_id"),
                    row.getString("quantity_per_unit"),
                    row.getDouble("unit_price"),
                    row.getInt("units_in_stock"),
                    row.getInt("units_on_order"),
                    row.getInt("reorder_level"),
                    row.getBoolean("discontinued")
            );
            products.add(product);
        }

        return products;
    }

    @Override
    public Product getProductById(int productId) {
        String sql = """
                SELECT product_id, product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued
                FROM products
                WHERE product_id = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, productId);

        if (row.next()) {
            return new Product(
                    row.getInt("product_id"),
                    row.getString("product_name"),
                    row.getInt("supplier_id"),
                    row.getInt("category_id"),
                    row.getString("quantity_per_unit"),
                    row.getDouble("unit_price"),
                    row.getInt("units_in_stock"),
                    row.getInt("units_on_order"),
                    row.getInt("reorder_level"),
                    row.getBoolean("discontinued")
            );
        }
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        String sql = """
                INSERT INTO products (product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getSupplierId());
            statement.setInt(3, product.getCategoryId());
            statement.setString(4, product.getQuantityPerUnit());
            statement.setDouble(5, product.getUnitPrice());
            statement.setInt(6, product.getUnitsInStock());
            statement.setInt(7, product.getUnitsOnOrder());
            statement.setInt(8, product.getReorderLevel());
            statement.setBoolean(9, product.isDiscontinued());
            return statement;
        }, keyHolder);

        int newId = keyHolder.getKey().intValue();

        return getProductById(newId);
    }

    public void updateProduct(int productId, Product product) {

        String sql = """
                UPDATE products
                SET product_name = ?
                , supplier_id = ?
                , category_id = ?
                , quantity_per_unit = ?
                , unit_price = ?
                , units_in_stock = ?
                , units_on_order = ?
                , reorder_level = ?
                , discontinued = ?
                WHERE product_id = ?
                """;

        jdbcTemplate.update(sql
                , product.getProductName()
                , product.getSupplierId()
                , product.getCategoryId()
                , product.getQuantityPerUnit()
                , product.getUnitPrice()
                , product.getUnitsInStock()
                , product.getUnitsOnOrder()
                , product.getReorderLevel()
                , product.isDiscontinued()
                , productId
        );

    }

    public void deleteProduct(int productId) {

        String sql = """
                DELETE FROM products
                WHERE product_id = ?
                """;

        jdbcTemplate.update(sql, productId);

    }

}