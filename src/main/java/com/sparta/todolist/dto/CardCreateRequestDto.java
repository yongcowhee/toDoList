package com.sparta.todolist.dto;

import lombok.Getter;

@Getter
public class CardCreateRequestDto {
    private String cardTitle;
    private String cardContent;
    private Long userId;
}
