package org.example.becoco.domain.post.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Table(name = "tal_post")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(columnDefinition = "varchar(16)", nullable = false)
    private String writer;

    @CreatedDate
    @Column(name = "create_date")
    private LocalDate createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDate updateDate;


    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String title;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String location;

    @Column(columnDefinition = "TEXT", length = 2500, nullable = false)
    private String content;


//    @ManyToOne
//    @JoinColumn(name = "userId")
//    private User user;


    public void update(String title, String location, String content) {
        this.title = title;
        this.location = location;
        this.content = content;
    }

}
