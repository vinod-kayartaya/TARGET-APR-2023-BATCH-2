package com.targetindia.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.targetindia.model.Product;

@Repository("dao")
public class JdbcTemplateProductDao implements ProductDao {

    // dependency
    @Autowired
    private JdbcTemplate template;


    public JdbcTemplateProductDao() {
    }

    // helper arrow function to map a row (in products table) to a Product object
    private RowMapper<Product> prm = (rs, rowNum) -> {
        Product p = new Product();
        p.setProductId(rs.getInt("product_id"));
        p.setProductName(rs.getString("product_name"));
        p.setSupplierId(rs.getInt("supplier_id"));
        p.setCategoryId(rs.getInt("category_id"));
        p.setQuantityPerUnit(rs.getString("quantity_per_unit"));
        p.setUnitPrice(rs.getDouble("unit_price"));
        p.setUnitsInStock(rs.getInt("units_in_stock"));
        p.setUnitsOnOrder(rs.getInt("units_on_order"));
        p.setReorderLevel(rs.getInt("reorder_level"));
        p.setDiscontinued(rs.getInt("discontinued"));
        return p;
    };


    @Override
    public void addProduct(Product p) throws DaoException {
        String sql = "insert into products values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatementCallback<Integer> psc = (ps) -> {
            ps.setInt(1, p.getProductId());
            ps.setString(2, p.getProductName());
            ps.setInt(3, p.getSupplierId());
            ps.setInt(4, p.getCategoryId());
            ps.setString(5, p.getQuantityPerUnit());
            ps.setDouble(6, p.getUnitPrice());
            ps.setInt(7, p.getUnitsInStock());
            ps.setInt(8, p.getUnitsOnOrder());
            ps.setInt(9, p.getReorderLevel());
            ps.setInt(10, p.getDiscontinued());
            return ps.executeUpdate();
        };
        template.execute(sql, psc);
    }

    @Override
    public void updateProduct(Product p) throws DaoException {
        String sql = "update products set product_name=?, supplier_id=?, category_id=?, quantity_per_unit=?, " +
                "unit_price=?, units_in_stock=?, units_on_order=?, reorder_level=?, discontinued=? where product_id=?";
        PreparedStatementCallback<Integer> psc = (ps) -> {
            ps.setString(1, p.getProductName());
            ps.setInt(2, p.getSupplierId());
            ps.setInt(3, p.getCategoryId());
            ps.setString(4, p.getQuantityPerUnit());
            ps.setDouble(5, p.getUnitPrice());
            ps.setInt(6, p.getUnitsInStock());
            ps.setInt(7, p.getUnitsOnOrder());
            ps.setInt(8, p.getReorderLevel());
            ps.setInt(9, p.getDiscontinued());
            ps.setInt(10, p.getProductId());
            return ps.executeUpdate();
        };
        template.execute(sql, psc);
    }

    @Override
    public Product getProductById(int productId) throws DaoException {
        return template.queryForObject("select*from products where product_id=?", prm, productId);
    }

    @Override
    public List<Product> getDiscontinuedProducts() throws DaoException {
        return template.query("select*from products where discontinued=1", prm);
    }

    @Override
    public List<Product> getProductsNotInStock() throws DaoException {
        return template.query("select*from products where units_in_stock=0", prm);
    }

    @Override
    public List<Product> getProductsByPriceRange(double min, double max) throws DaoException {
        String sql = "select*from products where unit_price between ? and ? order by unit_price";
        return template.query(sql, prm, min, max);
    }

    @Override
    public List<Product> getAllProducts() throws DaoException {
        return template.query("select*from products", prm);
    }
}
