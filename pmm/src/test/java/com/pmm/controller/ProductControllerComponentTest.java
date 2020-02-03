package com.pmm.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pmm.AbstractComponentTest;
import com.pmm.entity.Product;
import com.pmm.service.ProductService;

public class ProductControllerComponentTest extends AbstractComponentTest  {
	
	
	ProductController productController;
	@Autowired
	private ProductService productService;
	
	@Before
	public void setUp() {
		productController = new ProductController(productService);
	}
	
	@Test
	public void testGetProducts() throws Exception {
		ResponseEntity<List<Product>> responseEntity = productController.getProducts();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(responseEntity.getBody().size() > 0);
	}
	
	

}
