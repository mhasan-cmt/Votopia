package com.teamPhoenix.votopia.controller;

import com.teamPhoenix.votopia.dto.APICustomResponse;
import com.teamPhoenix.votopia.dto.GenericController;
import com.teamPhoenix.votopia.entity.Post;
import com.teamPhoenix.votopia.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController extends GenericController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getPosts(){
        List<Post> posts=postService.getPosts();
        if (posts.isEmpty())
            return createResponse(null,"No posts found", NOT_FOUND);

        return createResponse(posts, "Posts retrieved successfully", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APICustomResponse> addPost(@RequestBody Post post){
        Post post1=postService.addPost(post);
        if (post1==null)
            return createResponse(null,"Post already exists", NOT_FOUND);

        return createResponse(post1, "Post added successfully", HttpStatus.CREATED);
    }
}
