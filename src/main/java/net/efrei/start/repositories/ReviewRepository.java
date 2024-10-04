package net.efrei.start.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.efrei.start.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {
}
