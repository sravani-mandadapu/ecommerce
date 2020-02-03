package com.pmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmm.entity.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {

}
