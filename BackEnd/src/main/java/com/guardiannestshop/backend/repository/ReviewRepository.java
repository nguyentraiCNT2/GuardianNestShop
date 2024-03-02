package com.guardiannestshop.backend.repository;

import com.guardiannestshop.backend.entity.ReviewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
    Optional<ReviewEntity> findByReviewid(Long reviewid);
    List<ReviewEntity> findByUserid(String userid, Pageable pageable);
    List<ReviewEntity> findByProductsid(Long productsid, Pageable pageable);
    List<ReviewEntity> findByEvaluate(Long evaluate, Pageable pageable);
    void deleteByReviewid(Long reviewid);
    ReviewEntity saveAndFlush(ReviewEntity reviewEntity);
}
