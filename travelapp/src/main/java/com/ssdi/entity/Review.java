package com.ssdi.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * author: adithya95
 */
@Entity
@Table(name="Review_table")
public class Review {
	@Id
	@GeneratedValue
	@Column(name="review_id")
	private Integer reviewId;
	
	@NotNull
	@Column(name="review")
	private String review;
	
	@NotNull
	@Column(name="rating")
	private float rating;
	
	@NotNull
	@Column(name="place")
	private String place;
	
	@NotNull
	@Column(name="DateAdded")
	private Date dateAdded;
	

	@ManyToOne
	@JoinColumn(name="userId", insertable=false, updatable=false)
		private User user;
	private Integer userId;
	

	public Review(){
		
	}
	  
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public Integer getUserId() {
			return userId;
		}

		/**
		 * @param userId the userId to set
		 */
	public void setUserId(Integer userId) {
			this.userId = userId;
		}
	
	public String getReview(){
		return review;
	}
	
	public void setReview(String review){
		this.review =review;
	}
	
	public float getRating(){
		return rating;
	}
	
	public void setRating(float rating){
		this.rating = rating;
	}
	
	public Date getDateAdded(){
		return dateAdded;
	}
	
	public void setDateAdded(Date dateAdded){
		this.dateAdded = dateAdded;
	}

	/**
	 * @return the reviewId
	 */
	public Integer getReviewId() {
		return reviewId;
	}

	/**
	 * @param reviewId the reviewId to set
	 */
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

}
