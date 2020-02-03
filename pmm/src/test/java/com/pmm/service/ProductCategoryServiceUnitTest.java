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

import com.pmm.entity.ProductCategory;
import com.pmm.repository.ProductCategoryRepository;
import com.pmm.service.ProductCategoryService;

public class ProductCategoryServiceUnitTest {
	
	@Mock
	ProductCategoryRepository productCategoryRepository;
	
	ProductCategoryService productCategoryService;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setup() {
		productCategoryService = new ProductCategoryService(productCategoryRepository);
	}
	
	@Test
	public void testGetById() throws Exception {
		String productCategoryId = "123";
		ProductCategory expectedProductCategory = new ProductCategory();
		expectedProductCategory.setCategoryId(productCategoryId);
		when(productCategoryRepository.findById(productCategoryId)).thenReturn(Optional.of(expectedProductCategory));
		ProductCategory actualProductCategory = productCategoryService.getById(productCategoryId);
		assertEquals(expectedProductCategory, actualProductCategory);
	}
	
	@Test
	public void testGetProductCategorys() throws Exception {
		List<ProductCategory> expectedProductCategories = new ArrayList<ProductCategory>();
		expectedProductCategories.add(new ProductCategory());
		expectedProductCategories.add(new ProductCategory());
		when(productCategoryRepository.findAll()).thenReturn(expectedProductCategories);
		List<ProductCategory> actualProductCategories = productCategoryService.getAllProductCategories();
		assertEquals(expectedProductCategories.size(), actualProductCategories.size());
	}
	
	@Test
	public void testCreateProductCategory() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(UUID.randomUUID().toString());
		when(productCategoryRepository.save(productCategory)).thenReturn(productCategory);
		ProductCategory actualProductCategory = productCategoryService.createProductCategory(productCategory);
		assertEquals(productCategory, actualProductCategory);
	}
	
	@Test
	public void testUpdateProductCategory() throws Exception {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(UUID.randomUUID().toString());
		when(productCategoryRepository.save(productCategory)).thenReturn(productCategory);
		ProductCategory actualProductCategory = productCategoryService.updateProductCategory(productCategory);
		assertEquals(productCategory, actualProductCategory);
	}
	
}
