package com.sparta.todolist.core.dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@AllArgsConstructor
public class CardCreateResponseDto {
    private String cardTitle;
    private String cardContent;

}
