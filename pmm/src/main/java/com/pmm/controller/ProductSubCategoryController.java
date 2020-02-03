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

import com.pmm.entity.ProductSubCategory;
import com.pmm.service.ProductSubCategoryService;

@RestController
@RequestMapping(path = "/productSubCategory")
public class ProductSubCategoryController {
	
	private ProductSubCategoryService productSubCategoryService;
		
		@Autowired
		public ProductSubCategoryController(ProductSubCategoryService productSubCategoryService) {
			this.productSubCategoryService = productSubCategoryService;
		}
		
		@GetMapping("/{productSubCategoryId}")
		public ResponseEntity<ProductSubCategory> getByProductSubCategoryId(@PathVariable String ProductSubCategoryId) {
			return ResponseEntity.ok(productSubCategoryService.getById(ProductSubCategoryId));
		}
		
		@GetMapping
		public ResponseEntity<List<ProductSubCategory>> getproductSubCategory() {
			return ResponseEntity.ok(productSubCategoryService.getAllProductSubCategories());
		}
		
		@PutMapping
		public ResponseEntity<ProductSubCategory> createProductSubCategory(@RequestBody ProductSubCategory productSubCategory) {
			productSubCategory = productSubCategoryService.createProductSubCategory(productSubCategory);
			return ResponseEntity.status(HttpStatus.CREATED).body(productSubCategory);
		}
		
		@PostMapping
		public ResponseEntity<Object> updateProductSubCategory(@RequestBody ProductSubCategory productSubCategory) {
			return ResponseEntity.ok(productSubCategoryService.updateProductSubCategory(productSubCategory));
		}
}
