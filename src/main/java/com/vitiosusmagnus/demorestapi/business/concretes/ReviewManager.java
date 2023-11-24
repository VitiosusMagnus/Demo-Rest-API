package com.vitiosusmagnus.demorestapi.business.concretes;

import com.vitiosusmagnus.demorestapi.business.abstracts.ReviewService;
import com.vitiosusmagnus.demorestapi.business.request.ReviewRequest;
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
    public Review getById(Long id) {
        Optional<Review> temp = reviewRepo.findById(id);
        return temp.orElseThrow();
    }



    @Override
    public Review create(long filmId, ReviewRequest reviewRequest) {
        Review review = new Review();
        review.setComment(reviewRequest.getComment());
        review.setName(reviewRequest.getName());
        review.setRating(reviewRequest.getRating());
        Optional<Film> temp = filmRepo.findById(filmId);
        if (temp.isPresent()){
            Film film = temp.get();
            review.setFilm(film);
            updateRatingById(filmId);
            return reviewRepo.save(review);
        }else {
            return null;
        }
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
        return reviewRepo.findReviewsByFilmId(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public void updateRatingById(Long filmId){
        Optional<Film> temp = filmRepo.findById(filmId);
        if (temp.isPresent()){
            Film film = temp.get();
            film.setRating(reviewRepo.findAverageRatingByFilmId(filmId));
            filmRepo.save(film);
        }
    }
}
