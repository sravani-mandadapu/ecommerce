package com.pmm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmm.entity.ProductSubCategory;
import com.pmm.repository.ProductSubCategoryRepository;

@Service
public class ProductSubCategoryService {

private ProductSubCategoryRepository productSubCategoryRepository;
	
	@Autowired
	public ProductSubCategoryService(ProductSubCategoryRepository productSubCategoryRepository) {
		this.productSubCategoryRepository = productSubCategoryRepository;
	}
	
	public ProductSubCategory getById(String productSubCategoryId) {
		return productSubCategoryRepository.findById(productSubCategoryId).get();
	}
	
	public List<ProductSubCategory> getAllProductSubCategories() {
		return productSubCategoryRepository.findAll();
	}
	
	public ProductSubCategory createProductSubCategory(ProductSubCategory productSubCategory) {
		productSubCategory.setSubCategoryId(UUID.randomUUID().toString());
		return productSubCategoryRepository.save(productSubCategory);
	}
	
	public ProductSubCategory updateProductSubCategory(ProductSubCategory productSubCategory) {
		return productSubCategoryRepository.save(productSubCategory);
	}
}


