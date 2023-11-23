package com.vitiosusmagnus.demorestapi.business.concretes;

import com.vitiosusmagnus.demorestapi.business.abstracts.ReviewService;
import com.vitiosusmagnus.demorestapi.dataaccess.abstracts.ReviewRepository;
import com.vitiosusmagnus.demorestapi.entities.concretes.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewManager implements ReviewService {

    @Autowired
    ReviewRepository repo;

    @Autowired
    FilmManager filmManager;
    @Override
    public Double findAverageRatingByFilmId(long id) {
        return repo.findAverageRatingByFilmId(id);
    }

    @Override
    public Review getById(Long id) {
        Optional<Review> temp = repo.findById(id);
        return temp.orElseThrow();
    }

    @Override
    public Review create(Review review) {
        filmManager.updateRatingById(review.getFilm().getId());
        return repo.save(review);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
        filmManager.updateRatingById(id);
    }

    @Override
    public List<Review> findReviewByFilmId(Long id) {
        return repo.findReviewByFilmId(id);
    }
}
