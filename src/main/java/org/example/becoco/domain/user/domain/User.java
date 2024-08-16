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

    @Column(name = "name", updatable = false, unique = true, nullable = false)
    private String name;

    @Column(name = "student_id", unique = true, nullable = false)
    private int studentId;

}
