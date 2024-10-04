package net.efrei.start.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import net.efrei.start.global.Theme;

import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String title;
  private int year;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "director_id")
  private Director director;

  @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
  private Set<Actor> actors;

  @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
  private Set<Review> reviews;

  @Enumerated(EnumType.STRING)
  private Theme theme;

  public Movie() {}

  public Movie(@NotBlank String title, @Min(0) int year, @NotNull Director director, @NotEmpty Set<Actor> actors) {
    this.title = title;
    this.year = year;
    this.director = director;
    this.actors = actors;
  }

  // Getters and setters

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Director getDirector() {
    return director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  public Set<Actor> getActors() {
    return actors;
  }

  public void setActors(Set<Actor> actors) {
    this.actors = actors;
  }

  public Theme getTheme() {
    return theme;
  }

  public void setTheme(Theme theme) {
    this.theme = theme;
  }

  public Set<Review> getReviews() {
    return reviews;
  }

  public void setReviews(Set<Review> reviews) {
    this.reviews = reviews;
  }
}