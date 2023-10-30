package com.teamPhoenix.votopia.service;

import com.teamPhoenix.votopia.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();

    Post addPost(Post post);
}
