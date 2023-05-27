package com.project.blog.controller;

import com.project.blog.dto.PostDto;
import com.project.blog.dto.UserDto;
import com.project.blog.model.User;
import com.project.blog.service.UserService;
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
public class HomeController {
    private UserService userService;
    // handler method to handle index page request
    @GetMapping("/blog/index")
    public String indexPage(){
        return "index";
    }

    // handler method to handle sign - up page request
    @GetMapping("/blog/sign-up")
    public String signUpPage(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "sign-up";
    }
    @PostMapping("/blog/users/save")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto,
                           BindingResult result,
                           Model model){
        User user = userService.findUserByEmail(userDto.getEmail());
        if(user != null){
            result.rejectValue("Email", null, "This email is already registered");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/sign-up";
        }
        userService.createUser(userDto);
        return "redirect:/sign-up?success";
    }

    @GetMapping("/sign-in")
    public String login(){
        return "sign-in";
    }

    @GetMapping("/blog/admin")
    public String adminPage(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "admin";
    }
}
