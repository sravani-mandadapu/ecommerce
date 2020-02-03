package com.pmm.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.pmm.entity.Product;
import com.pmm.repository.ProductRepository;
import com.pmm.service.ProductService;



public class ProductServiceUnitTest {
	
	@Mock
	ProductRepository productRepository;
	
	ProductService productService;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setup() {
		productService = new ProductService(productRepository);
	}
	
	@Test
	public void testGetProducts() throws Exception {
		List<Product> expectedProducts = new ArrayList<Product>();
		expectedProducts.add(new Product());
		expectedProducts.add(new Product());
		when(productRepository.findAll()).thenReturn(expectedProducts);
		List<Product> actualProducts = productService.getProducts();
		assertEquals(expectedProducts.size(), actualProducts.size());
	}
	
	@Test
	public void testGetById() throws Exception {
		String productId = "1234";
		Product expectedProduct = new Product();
		expectedProduct.setProductId(productId);
		when(productRepository.findById(productId)).thenReturn(Optional.of(expectedProduct));
		Product actualProduct = productService.getById(productId);
		assertEquals(expectedProduct, actualProduct);
	}
	
	@Test
	public void testCreateProduct() throws Exception {
		Product product = new Product();
		product.setProductId(UUID.randomUUID().toString());
		when(productRepository.save(product)).thenReturn(product);
		Product actualProduct = productService.createProduct(product);
		assertEquals(product, actualProduct);
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		Product product = new Product();
		product.setProductId(UUID.randomUUID().toString());
		when(productRepository.save(product)).thenReturn(product);
		Product actualProduct = productService.updateProduct(product);
		assertEquals(product, actualProduct);
	}
	
	
}
