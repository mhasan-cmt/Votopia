package com.teamPhoenix.votopia.repository;

import com.teamPhoenix.votopia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
