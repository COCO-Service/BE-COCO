package org.example.becoco.domain.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name", updatable = false, unique = true, nullable = false)
    private String userName;

    @Column(name = "role", updatable = false, nullable = false)
    private String role;

    @Column(name = "student_id", unique = true, nullable = false)
    private int studentId;

}
