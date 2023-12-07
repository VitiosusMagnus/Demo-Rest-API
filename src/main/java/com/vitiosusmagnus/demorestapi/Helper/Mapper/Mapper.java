package com.vitiosusmagnus.demorestapi.Helper.Mapper;

import com.vitiosusmagnus.demorestapi.business.request.FilmRequest;
import com.vitiosusmagnus.demorestapi.business.request.ReviewRequest;
import com.vitiosusmagnus.demorestapi.business.response.FilmResponse;
import com.vitiosusmagnus.demorestapi.business.response.ReviewResponse;
import com.vitiosusmagnus.demorestapi.entities.concretes.Film;
import com.vitiosusmagnus.demorestapi.entities.concretes.Review;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Mapper {
    private final ModelMapper mapper;


    public Mapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        this.mapper = mapper;
    }

//    public ReviewRequest reviewToRequest(Review review){
//        return mapper.map(review,ReviewRequest.class);
//    }
    public Review requestToReview(ReviewRequest reviewRequest){
        return mapper.map(reviewRequest,Review.class);
    }
    public ReviewResponse reviewToResponse(Review review){
        return mapper.map(review,ReviewResponse.class);
    }
    public List<ReviewResponse> reviewsToResponses(List<Review> reviews){
        return reviews.stream().map(review -> mapper.map(review,ReviewResponse.class)).toList();
    }



    //films
    public FilmResponse filmToGetResponse(Film film){
        return mapper.map(film, FilmResponse.class);
    }
    public Film createRequestToFilm(FilmRequest filmRequest){
        return mapper.map(filmRequest,Film.class);
    }
    public FilmRequest filmToCreateRequest(Film film){
        return mapper.map(film,FilmRequest.class);
    }
    public List<FilmResponse> filmsToGetResponses(List<Film> films) {
        return films.stream().map(film -> mapper.map(film,FilmResponse.class)).toList();
    }
    public Film updateRequestToFilm(Film film, FilmRequest filmRequest){
          Film newFilm = mapper.map(filmRequest, Film.class);
         newFilm.setId(film.getId());
         newFilm.setRating(film.getRating());
         newFilm.setReviews(film.getReviews());
         return newFilm;
    }
}
