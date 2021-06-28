package com.doan.repository;

import com.doan.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT a FROM Product a")
    List<Product> getAllProduct();

    @Query("SELECT a FROM Product a WHERE a.status = ?1")
    List<Product> getProductByStatus(boolean status);

    @Query("SELECT a FROM Product a WHERE a.visible = ?1")
    List<Product> getProductByVisible(boolean visible);

    @Query("SELECT a FROM Product a WHERE a.productId = ?1")
    Product getProductById(Integer productId);

    @Query("SELECT a FROM Product a WHERE a.productTypeId = ?1 AND a.visible = ?2")
    List<Product> getProductsByTypeIdVisible(Integer productTypeId, boolean visible);



}
