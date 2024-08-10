package com.habibi.spring_batch.batch;

import com.habibi.spring_batch.entity.UserEntity;
import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class UserItemReader {
    private final int size = 5;

    @Bean
    public JpaPagingItemReader<UserEntity> userReader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<UserEntity>()
                .name("userReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT u FROM UserEntity u")
//                .pageSize(size)
                .build();
    }
}
