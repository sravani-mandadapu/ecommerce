package com.pmm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmm.entity.ProductReview;


@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, String> {

}
