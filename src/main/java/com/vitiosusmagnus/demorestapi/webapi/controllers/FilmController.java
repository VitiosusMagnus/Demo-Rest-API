package com.vitiosusmagnus.demorestapi.webapi.controllers;

import com.vitiosusmagnus.demorestapi.business.concretes.FilmManager;
import com.vitiosusmagnus.demorestapi.business.request.FilmRequest;
import com.vitiosusmagnus.demorestapi.entities.concretes.Film;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private FilmManager manager;

    public FilmController(FilmManager manager) {
        this.manager = manager;
    }

    @GetMapping("{id}")
    public Film getFilm(@PathVariable("id") long id){
        return manager.getById(id);
    }

    @GetMapping
    public List<Film> getAll(){
        return manager.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        manager.deleteById(id);
    }

    @PostMapping
    public Film create(@RequestBody FilmRequest filmRequest){
        Film film = new Film();
        film.setActors(filmRequest.getActors());
        film.setUrl(filmRequest.getUrl());
        film.setName(filmRequest.getName());
        film.setDescription(filmRequest.getDescription());
        return manager.create(film);
    }

    @PutMapping("/{id}")
    public Film updateById(@PathVariable long id, @RequestBody Film film) {
        return manager.updateById(id,film);
    }
}
