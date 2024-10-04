package net.efrei.start.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String review;
  private int rating;

  @ManyToOne(cascade = CascadeType.ALL)
  private Movie movie;

  @ManyToOne(cascade = CascadeType.ALL)
  private Viewer viewer;

  public Review() {}

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public Viewer getViewer() {
    return viewer;
  }

  public void setViewer(Viewer viewer) {
    this.viewer = viewer;
  }
}
