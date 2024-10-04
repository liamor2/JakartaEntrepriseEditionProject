package net.efrei.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.efrei.start.dto.CreateMovie;
import net.efrei.start.models.Actor;
import net.efrei.start.models.Movie;
import net.efrei.start.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
  
  @Autowired
  private MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public Iterable<Movie> findAll() {
    return movieService.findAll();
  }

  @GetMapping("/{id}")
  public Movie findById(String id) {
    return movieService.findById(id);
  }

  @PostMapping
public void create(Movie newMovie) {
    CreateMovie createMovie = new CreateMovie();
    createMovie.setTitle(newMovie.getTitle());
    createMovie.setYear(newMovie.getYear());
    if (newMovie.getTheme() != null) {
        createMovie.setGenre(newMovie.getTheme().toString());
    } else {
        createMovie.setGenre("Unknown");  // Set a default or handle the error as appropriate
    }
    createMovie.setDirectorID(newMovie.getDirector().getId());
    String[] actorsIDs = new String[newMovie.getActors().size()];
    int i = 0;
    for (Actor actor : newMovie.getActors()) {
        actorsIDs[i] = actor.getId();
        i++;
    }
    createMovie.setActorsIDs(actorsIDs);
    movieService.create(createMovie);
}

  @PutMapping("/{id}")
  public void update(String id, Movie newMovie) {
    CreateMovie createMovie = new CreateMovie();
    createMovie.setTitle(newMovie.getTitle());
    createMovie.setYear(newMovie.getYear());
    createMovie.setGenre(newMovie.getTheme().toString());
    createMovie.setDirectorID(newMovie.getDirector().getId());
    String[] actorsIDs = new String[newMovie.getActors().size()];
    int i = 0;
    for (Actor actor : newMovie.getActors()) {
      actorsIDs[i] = actor.getId();
      i++;
    }
    createMovie.setActorsIDs(actorsIDs);
    movieService.update(id, createMovie);
  }

  @PatchMapping("/{id}")
  public void patch(String id, Movie newMovie) {
    CreateMovie createMovie = new CreateMovie();
    createMovie.setTitle(newMovie.getTitle());
    createMovie.setYear(newMovie.getYear());
    createMovie.setGenre(newMovie.getTheme().toString());
    createMovie.setDirectorID(newMovie.getDirector().getId());
    String[] actorsIDs = new String[newMovie.getActors().size()];
    int i = 0;
    for (Actor actor : newMovie.getActors()) {
      actorsIDs[i] = actor.getId();
      i++;
    }
    createMovie.setActorsIDs(actorsIDs);
    movieService.update(id, createMovie);
  }

  @DeleteMapping("/{id}")
  public void delete(String id) {
    movieService.delete(id);
  }
}
