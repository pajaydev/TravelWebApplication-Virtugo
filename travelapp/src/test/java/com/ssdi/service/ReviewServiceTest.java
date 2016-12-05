package com.ssdi.service;

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
import com.ssdi.repository.ReviewRepository;

@RunWith(JUnit4.class)
public class ReviewServiceTest {

	@Mock
	private ReviewRepository repository;
	
	private ReviewService service;
	private Review review;
	private Review review2;
	private List<Review> reviews;
	
	@Before
	public void setup() {
		service = new ReviewService();
		reviews = new ArrayList<Review>();
		repository = mock(ReviewRepository.class);
		service.setReviewRepository(repository);
		
		review = new Review();
		review.setPlace("Mumbai");
		review.setDateAdded(new java.sql.Date(new Date().getTime()));
		review2 = new Review();
		review2.setPlace("USA");
		review2.setReview(null);
		review2.setDateAdded(new java.sql.Date(new Date().getTime()));
		
		when(repository.findReviewsByPlace(review.getPlace())).thenReturn(new ArrayList<Review>());
		when(repository.save(review)).thenReturn(review);
		when(repository.findReviewsByPlace(review2.getPlace())).thenReturn(new ArrayList<Review>());
		when(repository.save(review2)).thenReturn(null);
		
	}
	
	@Test
	public void testGetReviewByPlace(){
		when(repository.findReviewsByPlace(review.getPlace())).thenReturn(reviews);
		assertEquals(reviews, service.getReviewsByPlace(review.getPlace()));
	}
	
	@Test
	public void testAddreview() {
		assertEquals(review, service.addReview(review));
	}
	
	@Test
	public void testInvalidGetReviewByPlace(){
		when(repository.findReviewsByPlace(review.getPlace())).thenReturn(reviews);
		when(repository.findReviewsByPlace(review2.getPlace())).thenReturn(reviews);
		assertEquals(service.getReviewsByPlace(review2.getPlace()), service.getReviewsByPlace(review.getPlace()));
	}
	
	@Test
	public void testInvalidAddreview() {
		assertEquals(null, service.addReview(review2));
	}
}
