package com.pmm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmm.entity.ProductCategory;
import com.pmm.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	
	private ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
	}
	
	public ProductCategory getById(String productCategoryId) {
		return productCategoryRepository.findById(productCategoryId).get();
	}
	
	public List<ProductCategory> getAllProductCategories() {
		return productCategoryRepository.findAll();
	}
	
	public ProductCategory createProductCategory(ProductCategory productCategory) {
		productCategory.setCategoryId(UUID.randomUUID().toString());
		return productCategoryRepository.save(productCategory);
	}
	
	public ProductCategory updateProductCategory(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}
}
