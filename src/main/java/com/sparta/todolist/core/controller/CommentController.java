package com.sparta.todolist.core.controller;

import com.sparta.todolist.core.dto.CommentCreateRequestDto;
import com.sparta.todolist.core.dto.CommentCreateResponseDto;
import com.sparta.todolist.core.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/comments")
    public CommentCreateResponseDto createComment(CommentCreateRequestDto commentCreateRequestDto){
        return commentService.createComment(commentCreateRequestDto);
    }
}
