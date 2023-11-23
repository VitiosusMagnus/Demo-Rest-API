package com.vitiosusmagnus.demorestapi.business.abstracts;

import com.vitiosusmagnus.demorestapi.entities.concretes.Film;

import java.util.List;

public interface FilmService {
     List<Film> getAll();
     Film getById(Long id);
     Film create(Film film);
     void deleteById(Long id);
     Film updateById(Long id,Film updatedFilm);

}
