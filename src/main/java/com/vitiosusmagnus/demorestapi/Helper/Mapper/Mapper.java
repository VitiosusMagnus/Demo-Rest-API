package com.vitiosusmagnus.demorestapi.Helper.Mapper;

import com.vitiosusmagnus.demorestapi.business.response.FilmResponse;
import com.vitiosusmagnus.demorestapi.entities.concretes.Film;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public FilmResponse filmToResponse(Film film) {
        FilmResponse filmResponse = new FilmResponse();
        filmResponse.setId(film.getId());
        filmResponse.setName(film.getName());
        filmResponse.setUrl(film.getUrl());
        filmResponse.setActors(film.getActors());
        filmResponse.setRating(film.getRating());
        filmResponse.setDescription(film.getDescription());
        filmResponse.setReviews(film.getReviews());
        return filmResponse;
    }

    public List<FilmResponse> filmsToResponses(List<Film> films) {
        List<FilmResponse> filmResponses = new ArrayList<>();
        for (Film film: films){
            FilmResponse filmResponse = new FilmResponse();
            filmResponse.setId(film.getId());
            filmResponse.setName(film.getName());
            filmResponse.setUrl(film.getUrl());
            filmResponse.setActors(film.getActors());
            filmResponse.setRating(film.getRating());
            filmResponse.setDescription(film.getDescription());
            filmResponse.setReviews(film.getReviews());
            filmResponses.add(filmResponse);
        }
        return filmResponses;
    }


}
