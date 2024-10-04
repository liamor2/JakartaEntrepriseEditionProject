package net.efrei.start.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.efrei.start.dto.CreateReview;
import net.efrei.start.models.Review;
import net.efrei.start.repositories.ReviewRepository;

@Service
public class ReviewService {

  private ReviewRepository reviewRepository;
  private MovieService movieService;
  
  @Autowired
  public ReviewService(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  public List<Review> findAll() {
    return (List<Review>) reviewRepository.findAll();
  }

  public Review findById(String id) {
    return reviewRepository.findById(id).orElse(null);
  }

  public void create(CreateReview createReview) {
    try {
      Review review = new Review();
      review.setReview(createReview.getReview());
      review.setRating(createReview.getRating());
      review.setMovie(movieService.findById(createReview.getMovieID()));
      reviewRepository.save(review);
    } catch (Exception e) {
      throw new IllegalArgumentException("Review with review " + createReview.getReview() + " already exists");
    }
  }

  public void update(String id, CreateReview createReview) {
    Review existing = reviewRepository.findById(id).orElse(null);
    if (existing != null) {
      updateExistingReview(existing, createReview);
      reviewRepository.save(existing);
    } else {
      throw new IllegalArgumentException("Review with id " + id + " not found");
    }
  }

  private void updateExistingReview(Review existing, CreateReview updates) {
    if (updates.getReview() != null) {
      existing.setReview(updates.getReview());
    }
    if (updates.getRating() != 0) {
      existing.setRating(updates.getRating());
    }
    if (updates.getMovieID() != null) {
      existing.setMovie(movieService.findById(updates.getMovieID()));
    }
  }

  public void delete(String id) {
    Review existing = reviewRepository.findById(id).orElse(null);
    if (existing != null) {
      reviewRepository.delete(existing);
    } else {
      throw new IllegalArgumentException("Review with id " + id + " not found");
    }
  }
}
