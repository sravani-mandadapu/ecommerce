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

import com.pmm.entity.ProductSubCategory;
import com.pmm.repository.ProductSubCategoryRepository;
import com.pmm.service.ProductSubCategoryService;

public class ProductSubCategoryServiceUnitTest {
	
	@Mock
	ProductSubCategoryRepository productSubCategoryRepository;
	
	ProductSubCategoryService productSubCategoryService;
	
	@Rule 
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setup() {
		productSubCategoryService = new ProductSubCategoryService(productSubCategoryRepository);
	}
	
	@Test
	public void testGetById() throws Exception {
		String productSubCategoryId = "123";
		ProductSubCategory expectedProductSubCategory = new ProductSubCategory();
		expectedProductSubCategory.setSubCategoryId(productSubCategoryId);
		when(productSubCategoryRepository.findById(productSubCategoryId)).thenReturn(Optional.of(expectedProductSubCategory));
		ProductSubCategory actualProductSubCategory = productSubCategoryService.getById(productSubCategoryId);
		assertEquals(expectedProductSubCategory, actualProductSubCategory);
	}
	
	@Test
	public void testGetProductSubCategorys() throws Exception {
		List<ProductSubCategory> expectedProductSubCategories = new ArrayList<ProductSubCategory>();
		expectedProductSubCategories.add(new ProductSubCategory());
		expectedProductSubCategories.add(new ProductSubCategory());
		when(productSubCategoryRepository.findAll()).thenReturn(expectedProductSubCategories);
		List<ProductSubCategory> actualProductSubCategories = productSubCategoryService.getAllProductSubCategories();
		assertEquals(expectedProductSubCategories.size(), actualProductSubCategories.size());
	}
	
	@Test
	public void testCreateProductSubCategory() throws Exception {
		ProductSubCategory productSubCategory = new ProductSubCategory();
		productSubCategory.setSubCategoryId(UUID.randomUUID().toString());
		when(productSubCategoryRepository.save(productSubCategory)).thenReturn(productSubCategory);
		ProductSubCategory actualProductSubCategory = productSubCategoryService.createProductSubCategory(productSubCategory);
		assertEquals(productSubCategory, actualProductSubCategory);
	}
	
	@Test
	public void testUpdateProductSubCategory() throws Exception {
		ProductSubCategory productSubCategory = new ProductSubCategory();
		productSubCategory.setSubCategoryId(UUID.randomUUID().toString());
		when(productSubCategoryRepository.save(productSubCategory)).thenReturn(productSubCategory);
		ProductSubCategory actualProductSubCategory = productSubCategoryService.updateProductSubCategory(productSubCategory);
		assertEquals(productSubCategory, actualProductSubCategory);
	}
	

}
