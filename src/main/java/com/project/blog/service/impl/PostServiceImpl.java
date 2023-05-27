package com.project.blog.service.impl;

import com.project.blog.dto.PostDto;
import com.project.blog.mapper.Mapper;
import com.project.blog.model.Post;
import com.project.blog.repository.PostRepository;
import com.project.blog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private Mapper mapper;
    @Override
    public void createPost(PostDto postDto) {
        Post post = mapper.modelMapper().map(postDto, Post.class);
        postRepository.save(post);
    }

    @Override
    public void updatePost(PostDto postDto, Long id) {

    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts
                .stream()
                .map(
                        post -> mapper.modelMapper().map(post, PostDto.class)
                ).collect(Collectors.toList());
    }
}
