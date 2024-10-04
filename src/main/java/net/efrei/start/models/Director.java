package net.efrei.start.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;
import net.efrei.start.global.Countries;

@Entity
public class Director extends Person {

  @OneToMany(mappedBy = "director")
  @JsonManagedReference
  private Set<Movie> movies;

  public Director() {
    super();
  }

  public Director(@NotBlank String name, @NotBlank String firstname, @Min(0) int age, Countries country) {
    super(name, firstname, age, country);
  }

  // Getters and setters
  public Set<Movie> getMovies() {
    return movies;
  }

  public void setMovies(Set<Movie> movies) {
    this.movies = movies;
  }
}