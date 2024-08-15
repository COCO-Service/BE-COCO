package org.example.becoco.domain.post.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.becoco.domain.post.entity.type.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tal_post")
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private boolean solved = false;

    @CreatedDate
    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;

    @LastModifiedDate
    @Column(name = "update_date", nullable = false)
    private LocalDate updateDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @NotBlank
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String title;

    @Column(columnDefinition = "varchar(200)")
    private String location;

    @NotBlank
    @Column(columnDefinition = "TEXT", length = 2500, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable = false)
    private User user;

    public void typeWrite(Type type) {
        this.type = type;
    }

    public void update(String title, String location, String content) {
        this.title = title;
        this.location = location;
        this.content = content;
    }

}

