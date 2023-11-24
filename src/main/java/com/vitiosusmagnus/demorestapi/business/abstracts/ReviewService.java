package com.vitiosusmagnus.demorestapi.business.abstracts;


import com.vitiosusmagnus.demorestapi.entities.concretes.Review;

import java.util.List;

public interface ReviewService {
    Double findAverageRatingByFilmId(long id);
    Review getById(Long id);
    Review create(Review review);
    void deleteById(Long id);
    List<Review> findReviewByFilmId(Long id);
    List<Review> getAllReviews();
}
