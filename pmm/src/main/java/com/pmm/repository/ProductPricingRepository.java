package com.pmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmm.entity.ProductPricing;

@Repository
public interface ProductPricingRepository extends JpaRepository<ProductPricing, String> {

}
