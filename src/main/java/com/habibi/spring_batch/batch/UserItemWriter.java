package com.habibi.spring_batch.batch;

import com.habibi.spring_batch.entity.ProcessedUserEntity;
import com.habibi.spring_batch.repository.ProcessedUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class UserItemWriter {
    private ProcessedUserRepository processedUserRepository;

    @Bean
    public ItemWriter<ProcessedUserEntity> userWriter() {
        return new ItemWriter<ProcessedUserEntity>() {
            @Override
            public void write(Chunk<? extends ProcessedUserEntity> chunk) throws Exception {
                final List<? extends ProcessedUserEntity> items = chunk.getItems();
                for (ProcessedUserEntity processedUserEntity : items) {
                    processedUserRepository.save(processedUserEntity);
                }
            }
        };
    }
}
