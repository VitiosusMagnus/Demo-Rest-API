package com.vitiosusmagnus.demorestapi.business.concretes;

import com.vitiosusmagnus.demorestapi.Helper.Mapper.Mapper;
import com.vitiosusmagnus.demorestapi.business.abstracts.FilmService;
import com.vitiosusmagnus.demorestapi.business.request.FilmRequest;
import com.vitiosusmagnus.demorestapi.business.response.FilmResponse;
import com.vitiosusmagnus.demorestapi.dataaccess.abstracts.FilmRepository;
import com.vitiosusmagnus.demorestapi.entities.concretes.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmManager implements FilmService {

    private final FilmRepository repo;
    private final Mapper mapper;

    public FilmManager(FilmRepository repo, Mapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<FilmResponse> getAll() {
       return mapper.filmsToResponses(repo.findAll());
    }

    @Override
    public Film getById(Long id) {
        Optional<Film> temp = repo.findById(id);
        return temp.orElse(null);
    }
    @Override
    public Film create(FilmRequest filmRequest) {
        Film film = new Film();
        film.setActors(filmRequest.getActors());
        film.setUrl(filmRequest.getUrl());
        film.setName(filmRequest.getName());
        film.setDescription(filmRequest.getDescription());
        return repo.save(film);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Film updateById(Long id,Film updatedFilm) {

        Optional<Film> temp = repo.findById(id);
        if (temp.isPresent()){
            Film film = temp.get();
            film.setName(updatedFilm.getName());
            film.setDescription(updatedFilm.getDescription());
            film.setUrl(updatedFilm.getUrl());
            film.setActors(updatedFilm.getActors());
            return repo.save(film);
        }else {
            return null;
        }
    }

}
