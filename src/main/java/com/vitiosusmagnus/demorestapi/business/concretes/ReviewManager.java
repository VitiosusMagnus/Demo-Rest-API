package com.vitiosusmagnus.demorestapi.business.concretes;

import com.vitiosusmagnus.demorestapi.business.abstracts.ReviewService;
import com.vitiosusmagnus.demorestapi.dataaccess.abstracts.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewManager implements ReviewService {

    @Autowired
    ReviewRepository repo;
    @Override
    public Double findAverageRatingByFilmId(long id) {
        return repo.findAverageRatingByFilmId(id);
    }
}
