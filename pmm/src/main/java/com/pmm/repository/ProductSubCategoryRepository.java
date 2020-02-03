package com.pmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmm.entity.ProductSubCategory;

@Repository
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, String> {

}
