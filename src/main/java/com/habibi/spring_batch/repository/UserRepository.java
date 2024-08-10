package com.habibi.spring_batch.repository;

import com.habibi.spring_batch.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}