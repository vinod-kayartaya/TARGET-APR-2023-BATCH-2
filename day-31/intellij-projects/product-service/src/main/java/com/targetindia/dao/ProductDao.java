package com.targetindia.dao;

import com.targetindia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    //@Query("from Product where unitPrice between ?1 and ?2")
    List<Product> findAllByUnitPriceBetween(double min, double max);

    // findByXyz and findAllByXyz --> spring data jpa convention to check the property "xyz" in the Product.java against the parameter
    List<Product> findAllByCategoryId(Integer categoryId); // from Product where categoryId=?
    List<Product> findAllBySupplierId(Integer supplierId); // from Product where supplierId=?
    List<Product> findAllBySupplierIdAndCategoryId(Integer supplierId, Integer categoryId); // from Product where supplierId=? and categoryId=?
}
