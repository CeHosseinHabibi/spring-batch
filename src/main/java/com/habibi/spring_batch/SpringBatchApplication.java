package com.habibi.spring_batch;

import com.habibi.spring_batch.entity.UserEntity;
import com.habibi.spring_batch.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class SpringBatchApplication {
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }

    @PostConstruct
    public void writeSomeUsers() {
        final List<UserEntity> users = userRepository.findAll();
        if (users.isEmpty()) {
            for (int i = 0; i < 10_000; i++) {
                userRepository.save(new UserEntity("User " + i));
            }
        }
    }
}