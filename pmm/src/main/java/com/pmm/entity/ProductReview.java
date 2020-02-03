package com.pmm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product_review")
public class ProductReview {
	
	@Id
	@Column(name="product_review_id")
	private String productReviewId;
	@Column(name="product_review")
	private String productReview;
	@Column(name="product_rating")
	private int productRating;
	@Column(name="user")
	private String user;
	@JoinColumn(name="product_id")
	@ManyToOne
	private Product product;
	
	public String getProductReviewId() {
		return productReviewId;
	}
	public void setProductReviewId(String productReviewId) {
		this.productReviewId = productReviewId;
	}
	public String getProductReview() {
		return productReview;
	}
	public void setProductReview(String productReview) {
		this.productReview = productReview;
	}
	public int getProductRating() {
		return productRating;
	}
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "ProductReview [productReviewId=" + productReviewId + ", productReview=" + productReview
				+ ", productRating=" + productRating + ", user=" + user + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productRating;
		result = prime * result + ((productReview == null) ? 0 : productReview.hashCode());
		result = prime * result + ((productReviewId == null) ? 0 : productReviewId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		ProductReview other = (ProductReview) obj;
		if (productRating != other.productRating)
			return false;
		if (productReview == null) {
			if (other.productReview != null)
				return false;
		} else if (!productReview.equals(other.productReview))
			return false;
		if (productReviewId == null) {
			if (other.productReviewId != null)
				return false;
		} else if (!productReviewId.equals(other.productReviewId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
