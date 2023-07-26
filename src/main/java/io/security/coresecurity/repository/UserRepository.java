package io.security.coresecurity.repository;

import io.security.coresecurity.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AccountEntity, Long> {
}

