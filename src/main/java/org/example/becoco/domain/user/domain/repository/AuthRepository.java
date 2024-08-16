package org.example.becoco.domain.user.domain.repository;


import org.example.becoco.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
