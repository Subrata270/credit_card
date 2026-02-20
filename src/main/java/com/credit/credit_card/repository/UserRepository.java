package com.credit.credit_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.credit.credit_card.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}