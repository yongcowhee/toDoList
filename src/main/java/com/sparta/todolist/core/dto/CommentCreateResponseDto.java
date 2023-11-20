package com.sparta.todolist.core.dto;

public class CommentCreateResponseDto {
    private String userName;
    private String comment;

    public CommentCreateResponseDto(String userName, String comment) {
        this.userName = userName;
        this.comment = comment;
    }
}
