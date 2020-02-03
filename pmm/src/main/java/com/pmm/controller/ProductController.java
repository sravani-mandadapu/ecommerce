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

import com.pmm.entity.Product;
import com.pmm.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getByProductId(@PathVariable String productId) {
		return ResponseEntity.ok(productService.getById(productId));
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(productService.getProducts());
	}
	
	@PutMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		product = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@PostMapping
	public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<Product>> findByNameLike(@PathVariable String name) {
		return ResponseEntity.ok(productService.getByName(name));
	}
}
