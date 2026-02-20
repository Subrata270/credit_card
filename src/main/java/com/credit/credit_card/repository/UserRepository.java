package com.credit.credit_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.credit.credit_card.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}