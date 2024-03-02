package com.guardiannestshop.backend.repository;

import com.guardiannestshop.backend.entity.BlackListEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlackListRepository extends JpaRepository<BlackListEntity,Long> {
    Optional<BlackListEntity> findByBalcklistid(Long balcklistid);
    List<BlackListEntity> findByBlacklistname(String blacklistname, Pageable pageable);
    List<BlackListEntity> findByUserid(String userid, Pageable pageable);
    void deleteByBalcklistid(Long balcklistid);
    BlackListEntity saveAndFlush(BlackListEntity blackListEntity);
}
