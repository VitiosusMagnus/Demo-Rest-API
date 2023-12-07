package com.vitiosusmagnus.demorestapi.business.abstracts;


import com.vitiosusmagnus.demorestapi.business.request.ReviewRequest;
import com.vitiosusmagnus.demorestapi.business.response.ReviewResponse;

import java.util.List;

public interface ReviewService {
    ReviewResponse getById(Long id);
    ReviewResponse create(long filmId, ReviewRequest reviewRequest);
    void deleteById(Long id);
    List<ReviewResponse> findReviewsByFilmId(Long id);
    List<ReviewResponse> getAllReviews();
}
