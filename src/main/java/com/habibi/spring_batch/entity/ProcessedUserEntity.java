package com.habibi.spring_batch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessedUserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public ProcessedUserEntity(String name) {
        this.name = name;
    }
}