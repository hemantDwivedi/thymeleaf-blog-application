package com.project.blog.controller;

import com.project.blog.dto.PostDto;
import com.project.blog.service.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

@AllArgsConstructor
public class BlogController {
    private PostService postService;

    // handle create blog post request
    @GetMapping("/blog/posts")
    public String blogPage(Model model){
        PostDto post = new PostDto();
        model.addAttribute("post", post);
        return "blog-post";
    }

    // handle save post
    @PostMapping("/blog/post/save")
    public String savePost(@Valid @ModelAttribute PostDto postDto,
                           BindingResult result,
                           Model model){
        if(result.hasErrors()){
            model.addAttribute("post", postDto);
            return "/blog-post";
        }
        postService.createPost(postDto);
        return "redirect:/blog/posts?success";
    }

    @GetMapping("/blog/blogs")
    public String blogListPage(Model model){
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "blogs";
    }
}
