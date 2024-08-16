package org.example.becoco.domain.auth.domain.repository;

import org.example.becoco.domain.auth.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByUserName(String userName);
}
