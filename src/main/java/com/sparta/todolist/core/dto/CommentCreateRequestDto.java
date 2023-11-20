package com.sparta.todolist.core.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequestDto {
    private Long userId;
    private Long cardId;
    private String comment;

}
