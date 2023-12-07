package com.vitiosusmagnus.demorestapi.webapi.controllers;

import com.vitiosusmagnus.demorestapi.business.abstracts.FilmService;
import com.vitiosusmagnus.demorestapi.business.concretes.FilmManager;
import com.vitiosusmagnus.demorestapi.business.request.FilmRequest;
import com.vitiosusmagnus.demorestapi.business.response.FilmResponse;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private final FilmService manager;

    public FilmController(FilmManager manager) {
        this.manager = manager;
    }

    @GetMapping("{id}")
    public FilmResponse getFilm(@PathVariable("id") long id){
        return manager.getById(id);
    }

    @GetMapping
    public List<FilmResponse> getAll(){
        return manager.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id){
        manager.deleteById(id);
    }

    @PostMapping
    public FilmRequest create(@Valid @RequestBody FilmRequest filmRequest){
        return manager.create(filmRequest);
    }

    @PutMapping("/{id}")
    public FilmResponse updateById(@PathVariable long id,@Valid @RequestBody FilmRequest film) {
        return manager.updateById(id,film);
    }
}
