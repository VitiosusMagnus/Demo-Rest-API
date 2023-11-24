package com.vitiosusmagnus.demorestapi.business.abstracts;


import com.vitiosusmagnus.demorestapi.business.request.ReviewRequest;
import com.vitiosusmagnus.demorestapi.entities.concretes.Review;

import java.util.List;

public interface ReviewService {
    Review getById(Long id);
    Review create(long filmId, ReviewRequest reviewRequest);
    void deleteById(Long id);
    List<Review> findReviewByFilmId(Long id);
    List<Review> getAllReviews();
}
