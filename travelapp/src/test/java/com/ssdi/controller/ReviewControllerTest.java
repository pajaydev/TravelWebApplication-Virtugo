package com.ssdi.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import com.ssdi.entity.Review;
import com.ssdi.service.ReviewService;

@RunWith(JUnit4.class)
public class ReviewControllerTest {

	@Mock
	private ReviewService service;
	
	private ReviewController controller;
	private Review review;
	private Review review2;
	private List<Review> reviews;
	
	@Before
	public void setup() {
		controller = new ReviewController();
		service = mock(ReviewService.class);
		controller.setReviewService(service);
		reviews = new ArrayList<Review>();
		
		review = new Review();
		review.setPlace("Mumbai");
		review.setDateAdded(new java.sql.Date(new Date().getTime()));
		review2 = new Review();
		review2.setPlace("USA");
		review2.setReview(null);
		review2.setDateAdded(new java.sql.Date(new Date().getTime()));
		
		when(service.getReviewsByPlace(review.getPlace())).thenReturn(new ArrayList<Review>());
		when(service.addReview(review)).thenReturn(review);
		when(service.getReviewsByPlace(review2.getPlace())).thenReturn(new ArrayList<Review>());
		when(service.addReview(review2)).thenReturn(null);
	}
	
	@Test
	public void testCreateReview() {
		assertEquals(review, controller.createReview(review));
	}
	
	@Test
	public void testGetReviews() {
		when(service.getReviewsByPlace(review.getPlace())).thenReturn(reviews);
		assertEquals(reviews, controller.GetReviews(review));
	}

	@Test
	public void testInvalidCreateReviews() {
		assertEquals(null, controller.createReview(review2));
	}
	
	@Test
	public void testInvalidGetReviews() {
		when(service.getReviewsByPlace(review.getPlace())).thenReturn(reviews);
		when(service.getReviewsByPlace(review2.getPlace())).thenReturn(reviews);
		assertEquals(controller.GetReviews(review2), controller.GetReviews(review));
	}
}
