package com.habibi.spring_batch.repository;

import com.habibi.spring_batch.entity.ProcessedUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedUserRepository extends JpaRepository<ProcessedUserEntity, Long> {
}