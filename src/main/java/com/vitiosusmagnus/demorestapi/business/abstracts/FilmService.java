package com.vitiosusmagnus.demorestapi.business.abstracts;

import com.vitiosusmagnus.demorestapi.business.request.FilmRequest;
import com.vitiosusmagnus.demorestapi.business.response.FilmResponse;

import java.util.List;

public interface FilmService {
     List<FilmResponse> getAll();
     FilmResponse getById(Long id);
     FilmRequest create(FilmRequest filmRequest);
     void deleteById(Long id);
     FilmResponse updateById(Long id,FilmRequest updatedFilm);

}
