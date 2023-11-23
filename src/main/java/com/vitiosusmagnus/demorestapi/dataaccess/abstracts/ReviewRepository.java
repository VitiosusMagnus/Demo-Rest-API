package com.vitiosusmagnus.demorestapi.dataaccess.abstracts;

import com.vitiosusmagnus.demorestapi.entities.concretes.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    Double findAverageRatingByFilmId(long id);
}
