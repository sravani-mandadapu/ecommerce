package com.pmm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_pricing")
public class ProductPricing {
	
	@Id
	@Column(name="product_pricing_id")
	private String productPricingId;
	@Column(name="size")
	private String size;
	@Column(name="colour")
	private String colour;
	@Column(name="price")
	private double price;
	@ManyToOne
	@JoinColumn(name="product_id")
	private  Product product;
	
	public String getProductPricingId() {
		return productPricingId;
	}
	public void setProductPricingId(String productPricingId) {
		this.productPricingId = productPricingId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "ProductPricing [productPricingId=" + productPricingId + ", size=" + size + ", colour=" + colour
				+ ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productPricingId == null) ? 0 : productPricingId.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		ProductPricing other = (ProductPricing) obj;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productPricingId == null) {
			if (other.productPricingId != null)
				return false;
		} else if (!productPricingId.equals(other.productPricingId))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
}
