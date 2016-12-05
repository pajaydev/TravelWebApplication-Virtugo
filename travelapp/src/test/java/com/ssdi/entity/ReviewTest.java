package com.ssdi.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReviewTest {

		private Review review;
		
		@Before
		public void setup() {
			review = new Review();
			java.sql.Date date = java.sql.Date.valueOf( "2010-01-31" );
			review.setDateAdded(date);
			review.setPlace("Mumbai");
			review.setRating(1);
			review.setReview("Good");
			review.setReviewId(1);
			review.setUserId(1);
		}
		
		@Test
		public void testGetDateAdded() {
			assertEquals("2010-01-31", review.getDateAdded().toString());
		}
		
		@Test
		public void testGetPlace() {
			assertEquals("Mumbai", review.getPlace());
		}
		
		@Test
		public void testGetRating() {
			assertEquals("1.0", Float.toString(review.getRating()));
		}
		
		@Test
		public void testGetReview() {
			assertEquals("Good", review.getReview());
		}
		
		@Test
		public void testGetUserId() {
			assertEquals("1", review.getUserId().toString());
		}
		


}
