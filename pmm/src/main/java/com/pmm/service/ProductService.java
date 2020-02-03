package com.pmm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmm.entity.Product;
import com.pmm.repository.ProductRepository;

@Service
public class ProductService {
	
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product getById(String productId) {
		Product product = productRepository.findById(productId).get();
		return product; 
	}
	
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		product.setProductId(UUID.randomUUID().toString());
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getByName(String name) {
		return productRepository.findByNameLike(name);
	}
}
