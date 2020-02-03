package com.pmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmm.entity.ProductSpecification;

@Repository
public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, String>  {

}
