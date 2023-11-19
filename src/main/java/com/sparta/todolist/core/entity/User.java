package com.sparta.todolist.core.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Card> cardList;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
