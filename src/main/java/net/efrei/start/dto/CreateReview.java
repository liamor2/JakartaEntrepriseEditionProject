package net.efrei.start.dto;

public class CreateReview {
  private String viewerID;
  private String movieID;
  private String review;
  private int rating;

  public CreateReview() {}

  public CreateReview(String viewerID, String movieID, String review, int rating) {
    this.viewerID = viewerID;
    this.movieID = movieID;
    this.review = review;
    this.rating = rating;
  }

  public String getViewerID() {
    return viewerID;
  }

  public String getMovieID() {
    return movieID;
  }

  public String getReview() {
    return review;
  }

  public int getRating() {
    return rating;
  }

  public void setViewerID(String viewerID) {
    this.viewerID = viewerID;
  }

  public void setMovieID(String movieID) {
    this.movieID = movieID;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}
