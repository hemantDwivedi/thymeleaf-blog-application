package com.project.blog.service;

import com.project.blog.dto.PostDto;

import java.util.List;

public interface PostService {
    void createPost(PostDto postDto);
    void updatePost(PostDto postDto, Long id);
    void deletePost(Long id);
    List<PostDto> findAllPosts();
}
