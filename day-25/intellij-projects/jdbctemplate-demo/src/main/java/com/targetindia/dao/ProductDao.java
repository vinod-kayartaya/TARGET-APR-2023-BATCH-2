package com.targetindia.dao;

import com.targetindia.model.Product;

import java.util.List;

public interface ProductDao {
    // CRUD and Query operations
    public void addProduct(Product product) throws DaoException;

    public Product getProductById(int productId) throws DaoException;

    public void updateProduct(Product product) throws DaoException;

    public List<Product> getDiscontinuedProducts() throws DaoException;

    public List<Product> getProductsNotInStock() throws DaoException;

    public List<Product> getProductsByPriceRange(double min, double max) throws DaoException;

    public List<Product> getAllProducts() throws DaoException;
}
