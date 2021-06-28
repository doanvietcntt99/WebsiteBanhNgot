package com.doan.repository;

import com.doan.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {

    @Query("SELECT a FROM ProductImage a WHERE a.productId = :productId")
    List<ProductImage> findProductImageByProductId(@Param("productId") Integer productId);

    @Query("SELECT a FROM ProductImage a WHERE a.status = :status")
    List<ProductImage> findProductImageByStatus(@Param("status") boolean status);

    @Query("SELECT a FROM ProductImage a WHERE a.productImageId = :productImageId")
    ProductImage findProductImageById(@Param("productImageId") Integer productImageId);

    @Query("SELECT e FROM ProductImage e WHERE e.nameImage like ?1")
    List<ProductImage> findProductImageByNameLike(String nameImage);
}
