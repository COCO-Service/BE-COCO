package org.example.becoco.domain.post.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "post")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "writer", nullable = false)
    private String writer;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "type", length = 30, nullable = false)
    private boolean type;

    @Column(name = "location", nullable = false, length = 200)
    private String location;

    @Column(name = "content", length = 2500, columnDefinition = "TEXT", nullable = false)
    private String content;

}
