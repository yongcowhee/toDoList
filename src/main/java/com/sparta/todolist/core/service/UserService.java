package com.sparta.todolist.core.service;

import com.sparta.todolist.core.dto.SignUpRequestDto;
import com.sparta.todolist.core.repository.UserRepository;
import com.sparta.todolist.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(SignUpRequestDto signUpRequestDto) {
        User user = new User(
                signUpRequestDto.getUsername(),
                passwordEncoder.encode(signUpRequestDto.getPassword()));
        User save = userRepository.save(user);
        return save;
    }
}
