package com.ssdi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.Create;
import com.ssdi.entity.Plan;
import com.ssdi.entity.Review;
import com.ssdi.service.ReviewService;

@RestController
public class ReviewController {

	ReviewService reviewService;

	@Autowired
	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}

	public ReviewController() {
	}

	public void setReviewService(ReviewService service) {
		this.reviewService = service;
	}

	@RequestMapping(value = "/createReview", method = RequestMethod.POST)
	public Review createReview(@Validated(Create.class) @RequestBody Review review) {
		/*
		 * if(null != plan.getDateTravel() || plan.getDateTravel().toString() ==
		 * ""){
		 */

		
		review.setDateAdded(new java.sql.Date(new Date().getTime()));
		return reviewService.addReview(review);
	}

	@RequestMapping(value = "/getReview", method = RequestMethod.POST)
	public List<Review> GetReviews(@Validated(Create.class) @RequestBody Review review) {
		
		return reviewService.getReviewsByPlace(review.getPlace());
	}

}
