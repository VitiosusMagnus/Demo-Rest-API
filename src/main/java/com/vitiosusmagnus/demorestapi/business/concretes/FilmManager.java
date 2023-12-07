package com.vitiosusmagnus.demorestapi.business.concretes;

import com.vitiosusmagnus.demorestapi.Helper.Mapper.Mapper;
import com.vitiosusmagnus.demorestapi.business.abstracts.FilmService;
import com.vitiosusmagnus.demorestapi.business.request.FilmRequest;
import com.vitiosusmagnus.demorestapi.business.response.FilmResponse;
import com.vitiosusmagnus.demorestapi.dataaccess.abstracts.FilmRepository;
import com.vitiosusmagnus.demorestapi.entities.concretes.Film;
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
       return mapper.filmsToGetResponses(repo.findAll());
    }

    @Override
    public FilmResponse getById(Long id) {
        Optional<Film> temp = repo.findById(id);
        return temp.map(mapper::filmToGetResponse).orElse(null);
    }
    @Override
    public FilmRequest create(FilmRequest filmRequest) {
        Film film = mapper.createRequestToFilm(filmRequest);
        film = repo.save(film);
        return mapper.filmToCreateRequest(film);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public FilmResponse updateById(Long id,FilmRequest updatedFilm) {

        Optional<Film> temp = repo.findById(id);
        if (temp.isPresent()){
            Film film = mapper.updateRequestToFilm(temp.get(),updatedFilm);
            film = repo.save(film);
            return mapper.filmToGetResponse(film);
        }else {
            return null;
        }
    }

}
