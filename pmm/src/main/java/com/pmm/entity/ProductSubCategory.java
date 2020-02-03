package com.pmm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_sub_category")
public class ProductSubCategory {
	@Id
	@Column(name="sub_category_id")
	private String subCategoryId;
	@Column(name="sub_category_name")
	private String subCategoryName;
	@JoinColumn(name="category_id")
	@ManyToOne
	private ProductCategory productCategory;
	
	@OneToMany(mappedBy = "productSubCategory")
	private List<Product> products;
	
	
	public String getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "ProductSubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subCategoryId == null) ? 0 : subCategoryId.hashCode());
		result = prime * result + ((subCategoryName == null) ? 0 : subCategoryName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductSubCategory other = (ProductSubCategory) obj;
		if (subCategoryId == null) {
			if (other.subCategoryId != null)
				return false;
		} else if (!subCategoryId.equals(other.subCategoryId))
			return false;
		if (subCategoryName == null) {
			if (other.subCategoryName != null)
				return false;
		} else if (!subCategoryName.equals(other.subCategoryName))
			return false;
		return true;
	}
}
