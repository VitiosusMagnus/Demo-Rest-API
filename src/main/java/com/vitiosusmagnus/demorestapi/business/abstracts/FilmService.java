package com.vitiosusmagnus.demorestapi.business.abstracts;

import com.vitiosusmagnus.demorestapi.business.request.FilmRequest;
import com.vitiosusmagnus.demorestapi.business.response.FilmResponse;
import com.vitiosusmagnus.demorestapi.entities.concretes.Film;

import java.util.List;

public interface FilmService {
     List<FilmResponse> getAll();
     Film getById(Long id);
     Film create(FilmRequest filmRequest);
     void deleteById(Long id);
     Film updateById(Long id,Film updatedFilm);

}
