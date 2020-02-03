package com.pmm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_image")
public class ProductImage {
	
	
	@Id
	@Column(name="product_image_id")
	private String productImageId;
	@Column(name="image_file_path")
	private String imageFilePath;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	public String getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(String productImageId) {
		this.productImageId = productImageId;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public String toString() {
		return "ProductImage [productImageId=" + productImageId + ", imageFilePath=" + imageFilePath + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageFilePath == null) ? 0 : imageFilePath.hashCode());
		result = prime * result + ((productImageId == null) ? 0 : productImageId.hashCode());
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
		ProductImage other = (ProductImage) obj;
		if (imageFilePath == null) {
			if (other.imageFilePath != null)
				return false;
		} else if (!imageFilePath.equals(other.imageFilePath))
			return false;
		if (productImageId == null) {
			if (other.productImageId != null)
				return false;
		} else if (!productImageId.equals(other.productImageId))
			return false;
		return true;
	}
}
