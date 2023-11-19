package com.sparta.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CardEditResponseDto {
    private String cardTitle;
    private String cardContent;
    private String userName;
    private LocalDateTime cardCreatedAt;
}
