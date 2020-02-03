package com.pmm.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "product_id")
	private String productId;
	@Column(name = "name")
	private String name;
	@Column(name = "brand")
	private String brand;
	@Column(name = "description")
	private String description;
	@Column(name = "made_in")
	private String madeIn;
	@Column(name = "days_to_deliver")
	private Integer daysToDeliver;
	@Column(name = "discount")
	private BigDecimal discount;
	@Column(name = "status")
	private String status;
	@JoinColumn(name = "sub_category_id")
	@ManyToOne
	private ProductSubCategory productSubCategory;
	@OneToMany(mappedBy = "product")
	private List<ProductImage> productImages;
	@OneToMany(mappedBy = "product")
	private List<ProductPricing> productPricings;
	@OneToMany(mappedBy = "product")
	private List<ProductReview> productReviews;
	@OneToMany(mappedBy = "product")
	private List<ProductSpecification> productSpecifications;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}
	public Integer getDaysToDeliver() {
		return daysToDeliver;
	}
	public void setDaysToDeliver(Integer daysToDeliver) {
		this.daysToDeliver = daysToDeliver;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ProductSubCategory getProductSubCategory() {
		return productSubCategory;
	}
	public void setProductSubCategory(ProductSubCategory productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
	
	public List<ProductImage> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}
	
	public List<ProductPricing> getProductPricings() {
		return productPricings;
	}
	public void setProductPricings(List<ProductPricing> productPricings) {
		this.productPricings = productPricings;
	}
	public List<ProductReview> getProductReviews() {
		return productReviews;
	}
	public void setProductReviews(List<ProductReview> productReviews) {
		this.productReviews = productReviews;
	}
	public List<ProductSpecification> getProductSpecifications() {
		return productSpecifications;
	}
	public void setProductSpecifications(List<ProductSpecification> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	
}
