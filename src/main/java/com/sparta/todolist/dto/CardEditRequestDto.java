package com.sparta.todolist.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CardEditRequestDto {
    private String cardTitle;
    private String cardContent;
}
