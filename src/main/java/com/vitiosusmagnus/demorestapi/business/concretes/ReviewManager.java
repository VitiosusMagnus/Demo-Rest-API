package com.vitiosusmagnus.demorestapi.business.concretes;

import com.vitiosusmagnus.demorestapi.Helper.Mapper.Mapper;
import com.vitiosusmagnus.demorestapi.business.abstracts.ReviewService;
import com.vitiosusmagnus.demorestapi.business.request.ReviewRequest;
import com.vitiosusmagnus.demorestapi.business.response.ReviewResponse;
import com.vitiosusmagnus.demorestapi.dataaccess.abstracts.FilmRepository;
import com.vitiosusmagnus.demorestapi.dataaccess.abstracts.ReviewRepository;
import com.vitiosusmagnus.demorestapi.entities.concretes.Film;
import com.vitiosusmagnus.demorestapi.entities.concretes.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewManager implements ReviewService {
    private final ReviewRepository reviewRepo;
    private final FilmRepository filmRepo;
    private final Mapper mapper;
    public ReviewManager(ReviewRepository reviewRepo, FilmRepository filmRepo, Mapper mapper) {
        this.reviewRepo = reviewRepo;
        this.filmRepo = filmRepo;
        this.mapper = mapper;
    }


    @Override
    public ReviewResponse getById(Long id) {
        Optional<Review> temp = reviewRepo.findById(id);
        return temp.map(mapper::reviewToResponse).orElse(null);
    }

    @Override
    public List<ReviewResponse> getAllReviews() {
        return mapper.reviewsToResponses(reviewRepo.findAll());
    }

    @Override
    public ReviewResponse create(long filmId, ReviewRequest reviewRequest) {
        Optional<Film> temp = filmRepo.findById(filmId);
        if (temp.isPresent()){
            Review review = mapper.requestToReview(reviewRequest);
            review.setFilm(temp.get());
            review = reviewRepo.save(review);
            updateRatingById(filmId);
            return mapper.reviewToResponse(review);
        }else return null;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Review> temp = reviewRepo.findById(id);
        reviewRepo.deleteById(id);
        temp.ifPresent(review -> updateRatingById(review.getFilm().getId()));
    }

    @Override
    public List<ReviewResponse> findReviewsByFilmId(Long filmId) {
        return mapper.reviewsToResponses(reviewRepo.findReviewsByFilmId(filmId));
    }

    public void updateRatingById(Long filmId){
        Optional<Film> temp = filmRepo.findById(filmId);
        if (temp.isPresent()){
            Film film = temp.get();
            film.setRating(Math.floor(reviewRepo.findAverageRatingByFilmId(filmId) * 10) / 10);
            filmRepo.save(film);
        }
    }
}
