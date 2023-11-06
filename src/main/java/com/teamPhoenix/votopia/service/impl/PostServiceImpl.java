package com.teamPhoenix.votopia.service.impl;

import com.teamPhoenix.votopia.entity.Post;
import com.teamPhoenix.votopia.repository.PostRepository;
import com.teamPhoenix.votopia.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post addPost(Post post) {
        Post exists = postRepository.findByPostNameIgnoreCase(post.getPostName());
        if (exists != null)
            return null;
        return postRepository.save(post);
    }
}
