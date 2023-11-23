package com.vitiosusmagnus.demorestapi.dataaccess.abstracts;

import com.vitiosusmagnus.demorestapi.entities.concretes.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
}
