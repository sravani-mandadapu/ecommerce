package com.pmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmm.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String> {

}
