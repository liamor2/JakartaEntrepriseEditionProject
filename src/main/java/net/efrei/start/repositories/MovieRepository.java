package net.efrei.start.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.efrei.start.models.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
}
