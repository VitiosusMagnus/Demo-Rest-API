package com.vitiosusmagnus.demorestapi.dataaccess.abstracts;

import com.vitiosusmagnus.demorestapi.entities.concretes.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.film.id = :filmId")
    Double findAverageRatingByFilmId(long filmId);

     @Query
    List<Review> findReviewsByFilmId(long id);
}
