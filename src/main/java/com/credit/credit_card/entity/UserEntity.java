package com.credit.credit_card.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")   // VERY IMPORTANT
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}
