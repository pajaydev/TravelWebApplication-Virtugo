package com.ssdi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ssdi.entity.Review;
import com.ssdi.repository.ReviewRepository;

@Service
public class ReviewService {

		ReviewRepository reviewRepository;
		
		@Autowired
		public ReviewService(ReviewRepository myReviewRepository) {
			super();
			this.reviewRepository = myReviewRepository;
		}
		
		public List<Review> getReviewsByPlace(String place) {
			List<Review> reviews = reviewRepository.findReviewsByPlace(place);
			return reviews;
		}
		
		public Review addReview(Review review){
			return reviewRepository.save(review);
		}
		
		public void deleteReview(int Id){
			reviewRepository.delete(Id);
		}
}
