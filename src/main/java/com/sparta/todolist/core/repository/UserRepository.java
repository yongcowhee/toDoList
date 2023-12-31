package com.sparta.todolist.core.repository;

import com.sparta.todolist.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);

    Optional<User> findByUserNameAndPassword(String username, String password);
}

