package com.vitiosusmagnus.demorestapi.business.concretes;

import com.vitiosusmagnus.demorestapi.business.abstracts.ReviewService;
import com.vitiosusmagnus.demorestapi.dataaccess.abstracts.FilmRepository;
import com.vitiosusmagnus.demorestapi.dataaccess.abstracts.ReviewRepository;
import com.vitiosusmagnus.demorestapi.entities.concretes.Film;
import com.vitiosusmagnus.demorestapi.entities.concretes.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewManager implements ReviewService {


    @Autowired
    ReviewRepository reviewRepo;

    @Autowired
    FilmRepository filmRepo;
    @Override
    public Double findAverageRatingByFilmId(long id) {
        return reviewRepo.findAverageRatingByFilmId(id);
    }

    @Override
    public Review getById(Long id) {
        Optional<Review> temp = reviewRepo.findById(id);
        return temp.orElseThrow();
    }



    @Override
    public Review create(Review review) {
        Review newReview = reviewRepo.save(review);
        updateRatingById(review.getFilm().getId());
        return newReview;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Review> temp = reviewRepo.findById(id);
        reviewRepo.deleteById(id);
        if (temp.isPresent()){
            updateRatingById(temp.get().getFilm().getId());
        }
    }

    @Override
    public List<Review> findReviewByFilmId(Long id) {
        return reviewRepo.findReviewByFilmId(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public void updateRatingById(Long id){
        Optional<Film> temp = filmRepo.findById(id);
        if (temp.isPresent()){
            Film film = temp.get();
            film.setRating(reviewRepo.findAverageRatingByFilmId(id));
            filmRepo.save(film);
        }
    }
}
