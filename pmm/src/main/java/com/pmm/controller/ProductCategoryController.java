package com.pmm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmm.entity.ProductCategory;
import com.pmm.service.ProductCategoryService;
@RestController
@RequestMapping(path = "/productCategory")
public class ProductCategoryController {
	
	private ProductCategoryService productCategoryService;
	
	@Autowired
	public ProductCategoryController(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<ProductCategory> getByCategoryId(@PathVariable String categoryId) {
		return ResponseEntity.ok(productCategoryService.getById(categoryId));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductCategory>> getproductCategory() {
		return ResponseEntity.ok(productCategoryService.getAllProductCategories());
	}
	
	@PutMapping
	public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategory productCategory) {
		productCategory = productCategoryService.createProductCategory(productCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(productCategory);
	}
	
	@PostMapping
	public ResponseEntity<Object> updateProductCategory(@RequestBody ProductCategory productCategory) {
		return ResponseEntity.ok(productCategoryService.updateProductCategory(productCategory));
		
	}

}
