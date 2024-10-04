package net.efrei.start.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;
import net.efrei.start.global.Countries;

@Entity
public class Actor extends Person {

  @ManyToMany
  @JoinTable(
    name = "actor_movie",
    joinColumns = @JoinColumn(name = "actor_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id")
  )
  @JsonBackReference
  private Set<Movie> movies;

  public Actor() {
    super();
  }

  public Actor(@NotBlank String name, @NotBlank String firstname, @Min(0) int age, Countries country, Set<Movie> movies) {
    super(name, firstname, age, country);
    this.movies = movies;
  }

  // Getters and setters
  public Set<Movie> getMovies() {
    return movies;
  }

  public void setMovies(Set<Movie> movies) {
    this.movies = movies;
  }
}