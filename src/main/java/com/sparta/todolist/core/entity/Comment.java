package com.sparta.todolist.core.entity;

import com.sparta.todolist.core.dto.CommentCreateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentContent;
    private String commentAuthor;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public Comment(Card card, CommentCreateRequestDto commentCreateRequestDto){
        this.card = card;
        this.commentContent = commentCreateRequestDto.getComment();
        this.commentAuthor = card.getUser().getUserName();
    }
}
