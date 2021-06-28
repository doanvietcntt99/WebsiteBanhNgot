package com.doan.repository;

import com.doan.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
    @Query("SELECT a FROM ProductType a")
    List<ProductType> getAllProductType();

    @Query("SELECT a FROM ProductType a WHERE a.status = ?1")
    List<ProductType> getAllProductTypeByStatus(boolean status);

}
