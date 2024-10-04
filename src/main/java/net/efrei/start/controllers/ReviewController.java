package net.efrei.start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.efrei.start.models.Review;
import net.efrei.start.services.ReviewService;
import net.efrei.start.dto.CreateReview;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping
  public Iterable<Review> findAll() {
    return reviewService.findAll();
  }

  @GetMapping("/{id}")
  public Review findById(String id) {
    return reviewService.findById(id);
  }

  @PostMapping
  public void create(Review newReview) {
    CreateReview createReview = new CreateReview();
    createReview.setMovieID(newReview.getMovie().getId());
    createReview.setViewerID(newReview.getViewer().getId());
    createReview.setRating(newReview.getRating());
    createReview.setReview(newReview.getReview());
    reviewService.create(createReview);
  }

  @PutMapping("/{id}")
  public void update(String id, Review newReview) {
    CreateReview createReview = new CreateReview();
    createReview.setMovieID(newReview.getMovie().getId());
    createReview.setViewerID(newReview.getViewer().getId());
    createReview.setRating(newReview.getRating());
    createReview.setReview(newReview.getReview());
    reviewService.update(id, createReview);
  }

  @PatchMapping("/{id}")
  public void patch(String id, Review newReview) {
    CreateReview createReview = new CreateReview();
    createReview.setMovieID(newReview.getMovie().getId());
    createReview.setViewerID(newReview.getViewer().getId());
    createReview.setRating(newReview.getRating());
    createReview.setReview(newReview.getReview());
    reviewService.update(id, createReview);
  }

  @DeleteMapping("/{id}")
  public void delete(String id) {
    reviewService.delete(id);
  }
}
