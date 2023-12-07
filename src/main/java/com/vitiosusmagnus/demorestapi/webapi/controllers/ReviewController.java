package com.vitiosusmagnus.demorestapi.webapi.controllers;

import com.vitiosusmagnus.demorestapi.business.abstracts.ReviewService;
import com.vitiosusmagnus.demorestapi.business.concretes.ReviewManager;
import com.vitiosusmagnus.demorestapi.business.request.ReviewRequest;
import com.vitiosusmagnus.demorestapi.business.response.ReviewResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService manager;

    public ReviewController(ReviewManager manager){
        this.manager = manager;
    }

    @GetMapping("{id}")
    public ReviewResponse getReview(@PathVariable long id){
        return manager.getById(id);
    }

    @GetMapping("/film{filmId}")
    public List<ReviewResponse> getReviewByFilmId(@PathVariable long filmId){
        return manager.findReviewsByFilmId(filmId);
    }

    @GetMapping
    public List<ReviewResponse> getAll(){
        return manager.getAllReviews();
    }

    @PostMapping("{filmId}")
    public ReviewResponse create(@PathVariable long filmId, @Valid @RequestBody ReviewRequest reviewRequest){
        return manager.create(filmId, reviewRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        manager.deleteById(id);
    }

}
