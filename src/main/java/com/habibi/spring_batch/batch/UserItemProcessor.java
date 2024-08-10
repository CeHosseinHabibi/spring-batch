package com.habibi.spring_batch.batch;

import com.habibi.spring_batch.entity.ProcessedUserEntity;
import com.habibi.spring_batch.entity.UserEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserItemProcessor implements ItemProcessor<UserEntity, ProcessedUserEntity> {
    @Override
    public ProcessedUserEntity process(UserEntity userEntity) {
        return new ProcessedUserEntity(userEntity.getName() + " processed");
    }
}