package net.efrei.start.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;
import net.efrei.start.global.Country;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actor extends Person {

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "actor_movie",
    joinColumns = @JoinColumn(name = "actor_id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id")
  )
  private Set<Movie> movies;

  public Actor() {
    super();
  }

  public Actor(@NotBlank String name, @NotBlank String firstname, @Min(0) int age, Country country, Set<Movie> movies) {
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