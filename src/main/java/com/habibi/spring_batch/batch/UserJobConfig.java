package com.habibi.spring_batch.batch;

import com.habibi.spring_batch.entity.ProcessedUserEntity;
import com.habibi.spring_batch.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@AllArgsConstructor
public class UserJobConfig {
    private static final int CHUNK_SIZE = 10;

    private JobRepository jobRepository;
    private PlatformTransactionManager transactionManager;
    private JpaPagingItemReader<UserEntity> userReader;
    private UserItemProcessor userProcessor;
    private ItemWriter<ProcessedUserEntity> userWriter;

    @Bean
    public Job userJob() {
        return new JobBuilder("userJob", jobRepository)
                .start(userStep())
                .build();
    }

    @Bean
    public Step userStep() {
        return new StepBuilder("userStep", jobRepository)
                .<UserEntity, ProcessedUserEntity>chunk(CHUNK_SIZE, transactionManager)
                .reader(userReader)
                .processor(userProcessor)
                .writer(userWriter)
                .build();
    }
}