package com.pmm.integration;

import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void testGetProductById() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/product/P123"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.productId", Is.is("P123")));
	}
	
	@Test
	public void testGetAllProducts() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/product"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
	}
	
	@Test
	public void testCreateProduct() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put("/product/P127"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/product"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Is.is("P127")));
	}
}
