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

import com.pmm.entity.ProductCategory;
import com.pmm.service.ProductCategoryService;

public class ProductCategoryControllerUnitTest {
	
	@Mock
	ProductCategoryService productCategoryService;
	
	ProductCategoryController productCategoryController;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() {
		productCategoryController = new ProductCategoryController(productCategoryService);
	}
	
	@Test
	public void testGetProductCategorys() throws Exception {
		List<ProductCategory> expectedProductCategories = new ArrayList<ProductCategory>();
		expectedProductCategories.add(new ProductCategory());
		expectedProductCategories.add(new ProductCategory());
		when(productCategoryService.getAllProductCategories()).thenReturn(expectedProductCategories);
		ResponseEntity<List<ProductCategory>> responseEntity = productCategoryController.getproductCategory();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		List<ProductCategory> actualProductCategorys = responseEntity.getBody();
		assertEquals(expectedProductCategories.size(), actualProductCategorys.size());
	}
	
	@Test
	public void testGetById() throws Exception {
		String categoryId = "1236";
		ProductCategory expectedProductCategory = new ProductCategory();
		expectedProductCategory.setCategoryId(categoryId);
		when(productCategoryService.getById(categoryId)).thenReturn(expectedProductCategory);
		ResponseEntity<ProductCategory> responseEntity = productCategoryController.getByCategoryId(categoryId);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		ProductCategory actualProductCategory = responseEntity.getBody();
		assertEquals(expectedProductCategory, actualProductCategory);	
	}
	
	@Test
	public void testCreateProductCategory() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(UUID.randomUUID().toString());
		ResponseEntity<ProductCategory> responseEntity = productCategoryController.createProductCategory(productCategory);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	@Test
	public void testUpdateProductCategory() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(UUID.randomUUID().toString());
		productCategory.setCategoryName("abc");
		ResponseEntity<Object> responseEntity = productCategoryController.updateProductCategory(productCategory);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	

}
