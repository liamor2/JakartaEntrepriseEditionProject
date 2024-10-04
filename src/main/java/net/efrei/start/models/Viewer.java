package net.efrei.start.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Viewer extends Person {
  private String favoriteMovie;

  @OneToMany(cascade = CascadeType.ALL)
  private Set<Review> reviews;

  public String getFavoriteMovie() {
    return favoriteMovie;
  }

  public void setFavoriteMovie(String favoriteMovie) {
    this.favoriteMovie = favoriteMovie;
  }
}
