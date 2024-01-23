package com.spring.registration1.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Component
@Entity
@Data
public class luser {
    @Id
    private String email;
    private String password;
}
