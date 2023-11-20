package com.sparta.todolist.core.service;

import com.sparta.todolist.core.dto.CommentCreateRequestDto;
import com.sparta.todolist.core.dto.CommentCreateResponseDto;
import com.sparta.todolist.core.entity.Card;
import com.sparta.todolist.core.entity.Comment;
import com.sparta.todolist.core.repository.CardRepository;
import com.sparta.todolist.core.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final CardRepository cardRepository;
    private final CommentRepository commentRepository;
    // 댓글 생성
    public CommentCreateResponseDto createComment(CommentCreateRequestDto commentCreateRequestDto){
        Card card = cardRepository.findById(commentCreateRequestDto.getCardId()).orElseThrow(()->
                new IllegalArgumentException("할일카드가 존재하지 않아 댓글을 작성할 수 없습니다."));
        Comment comment = new Comment(card, commentCreateRequestDto);
        commentRepository.save(comment);

        CommentCreateResponseDto commentCreateResponseDto = new CommentCreateResponseDto(
                comment.getCommentContent(), comment.getCommentAuthor()
        );

        return commentCreateResponseDto;
    }
    // 댓글 수정
    // 댓글 삭제

}
