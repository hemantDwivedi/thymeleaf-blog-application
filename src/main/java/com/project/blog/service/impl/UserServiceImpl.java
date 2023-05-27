package com.project.blog.service.impl;

import com.project.blog.dto.UserDto;
import com.project.blog.mapper.Mapper;
import com.project.blog.model.Role;
import com.project.blog.model.User;
import com.project.blog.repository.RoleRepository;
import com.project.blog.repository.UserRepository;
import com.project.blog.service.UserService;
import lombok.AllArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
    private Mapper mapper;
    @Override
    public void createUser(UserDto userDto) {
        User user = mapper.modelMapper().map(userDto, User.class);
        user.setPassword(userDto.getPassword());
        Role role = roleRepository.findByRoleName("ROLE_ADMIN");
        if (role == null){
            role = existRole();
        }
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(
                        user -> mapper.modelMapper().map(user, UserDto.class)
                ).collect(Collectors.toList());
    }

    private Role existRole() {
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
