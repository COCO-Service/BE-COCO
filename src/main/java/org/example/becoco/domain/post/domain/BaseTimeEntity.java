package org.example.becoco.domain.post.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDate createDate; //Entity가 생성되어 저장될 때 시간이 자동 저장

    @LastModifiedDate
    private LocalDate updateDate; //조회한 Entity의 값을 변경할 때 시간이 자동 저장
}