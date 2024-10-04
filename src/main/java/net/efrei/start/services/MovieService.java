package net.efrei.start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.efrei.start.dto.CreateMovie;
import net.efrei.start.global.Theme;
import net.efrei.start.models.Actor;
import net.efrei.start.models.Director;
import net.efrei.start.models.Movie;
import net.efrei.start.repositories.MovieRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService {

  private final MovieRepository movieRepository;
  private final DirectorService directorService;
  private final ActorService actorService;

  @Autowired
  public MovieService(MovieRepository movieRepository, DirectorService directorService, ActorService actorService) {
    this.movieRepository = movieRepository;
    this.directorService = directorService;
    this.actorService = actorService;
  }

  public List<Movie> findAll() {
    return (List<Movie>) movieRepository.findAll();
  }

  public Movie findById(String id) {
    return movieRepository.findById(id).orElse(null);
  }

  public void create(CreateMovie createMovie) {
    try {
      Movie movie = new Movie();
      Director director = directorService.findById(createMovie.getDirectorID());
      Set<Actor> actors = new HashSet<>();
      for (String actorId : createMovie.getActorsIDs()) {
        Actor actor = actorService.findById(actorId);
        if (actor != null) {
          actors.add(actor);
        }
      }
      movie.setActors(actors);
      movie.setDirector(director);
      movie.setTitle(createMovie.getTitle());
      movie.setYear(createMovie.getYear());
      movie.setTheme(Theme.valueOf(createMovie.getGenre().toUpperCase()));
      movieRepository.save(movie);
    } catch (Exception e) {
      throw new IllegalArgumentException("Movie with title " + createMovie.getTitle() + " already exists");
    }
  }
}