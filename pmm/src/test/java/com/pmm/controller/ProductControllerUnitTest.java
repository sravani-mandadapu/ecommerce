package com.pmm.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pmm.entity.Product;
import com.pmm.service.ProductService;

public class ProductControllerUnitTest {
	
	@Mock
	ProductService productService;
	
	ProductController productController;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() {
		productController = new ProductController(productService);
	}
	
	@Test
	public void testGetProducts() throws Exception {
		List<Product> expectedProducts = new ArrayList<Product>();
		expectedProducts.add(new Product());
		expectedProducts.add(new Product());
		when(productService.getProducts()).thenReturn(expectedProducts);
		ResponseEntity<List<Product>> responseEntity = productController.getProducts();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		List<Product> actualProducts = responseEntity.getBody();
		assertEquals(expectedProducts.size(), actualProducts.size());
	}
	
	@Test
	public void testGetById() throws Exception {
		String productId = "1235";
		Product expectedProduct = new Product();
		expectedProduct.setProductId(productId);
		when(productService.getById(productId)).thenReturn(expectedProduct);
		ResponseEntity<Product> responseEntity = productController.getByProductId(productId);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Product actualProduct = responseEntity.getBody();
		assertEquals(expectedProduct, actualProduct);	
	}
	
	@Test
	public void testCreateProduct() throws Exception {
		Product product = new Product();
		product.setProductId(UUID.randomUUID().toString());
		ResponseEntity<Product> responseEntity = productController.createProduct(product);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		Product product = new Product();
		product.setProductId(UUID.randomUUID().toString());
		product.setName("XYZ");
		ResponseEntity<Object> responseEntity = productController.updateProduct(product);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	
}
