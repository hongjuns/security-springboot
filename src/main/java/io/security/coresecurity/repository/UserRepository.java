package io.security.coresecurity.repository;

import io.security.coresecurity.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findAccountEntityByUsername (String userName);
}

