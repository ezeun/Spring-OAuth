package com.ssafy.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.back.entity.CertificationEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CertificationRepository extends JpaRepository<CertificationEntity, String> {
    
    CertificationEntity findByUserId(String UserId);

    @Transactional
    void deleteByUserId(String userId);
}
