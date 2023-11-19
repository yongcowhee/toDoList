package com.sparta.todolist.core.dto;

import lombok.Getter;

@Getter
public class CardCreateRequestDto {
    private String cardTitle;
    private String cardContent;
    private Long userId;
}
