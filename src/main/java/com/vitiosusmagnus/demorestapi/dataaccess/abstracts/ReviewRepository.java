package com.vitiosusmagnus.demorestapi.dataaccess.abstracts;

import com.vitiosusmagnus.demorestapi.entities.concretes.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    Double findAverageRatingByFilmId(long id);
    List<Review> findReviewByFilmId(long id);
}
