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

import com.pmm.entity.ProductSubCategory;
import com.pmm.service.ProductSubCategoryService;

public class ProductSubCategoryControllerUnitTest {
	
	@Mock
	ProductSubCategoryService productSubCategoryService;
	
	ProductSubCategoryController productSubCategoryController;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() {
		productSubCategoryController = new ProductSubCategoryController(productSubCategoryService);
	}
	
	@Test
	public void testGetProductSubCategorys() throws Exception {
		List<ProductSubCategory> expectedProductSubCategories = new ArrayList<ProductSubCategory>();
		expectedProductSubCategories.add(new ProductSubCategory());
		expectedProductSubCategories.add(new ProductSubCategory());
		when(productSubCategoryService.getAllProductSubCategories()).thenReturn(expectedProductSubCategories);
		ResponseEntity<List<ProductSubCategory>> responseEntity = productSubCategoryController.getproductSubCategory();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		List<ProductSubCategory> actualProductSubCategorys = responseEntity.getBody();
		assertEquals(expectedProductSubCategories.size(), actualProductSubCategorys.size());
	}
	
	@Test
	public void testGetById() throws Exception {
		String SubCategoryId = "1236";
		ProductSubCategory expectedProductSubCategory = new ProductSubCategory();
		expectedProductSubCategory.setSubCategoryId(SubCategoryId);
		when(productSubCategoryService.getById(SubCategoryId)).thenReturn(expectedProductSubCategory);
		ResponseEntity<ProductSubCategory> responseEntity = productSubCategoryController.getByProductSubCategoryId(SubCategoryId);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		ProductSubCategory actualProductSubCategory = responseEntity.getBody();
		assertEquals(expectedProductSubCategory, actualProductSubCategory);	
	}
	
	@Test
	public void testCreateProductSubCategory() throws Exception {
		ProductSubCategory productSubCategory = new ProductSubCategory();
		productSubCategory.setSubCategoryId(UUID.randomUUID().toString());
		ResponseEntity<ProductSubCategory> responseEntity = productSubCategoryController.createProductSubCategory(productSubCategory);
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
	}
	
	@Test
	public void testUpdateProductSubCategory() throws Exception {
		ProductSubCategory productSubCategory = new ProductSubCategory();
		productSubCategory.setSubCategoryId(UUID.randomUUID().toString());
		productSubCategory.setSubCategoryName("abc");
		ResponseEntity<Object> responseEntity = productSubCategoryController.updateProductSubCategory(productSubCategory);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	

}
