package com.hamtaro.sunflowerplate.repository.review;

import com.hamtaro.sunflowerplate.entity.review.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    Optional<ReviewEntity> findByReviewId(Long reviewId);
    Page<ReviewEntity> findAllByRestaurantEntity_RestaurantId(Long restaurantId, Pageable pageable);
}
