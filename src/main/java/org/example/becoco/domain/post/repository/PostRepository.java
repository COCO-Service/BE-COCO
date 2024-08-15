package org.example.becoco.domain.post.repository;

import org.example.becoco.domain.post.dto.response.PostListElement;
import org.example.becoco.domain.post.entity.Post;
import org.example.becoco.domain.post.entity.type.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostListElement> findAllByType(Type type);
}
