package com.sparta.todolist.entity;

import jakarta.persistence.*;

@Entity
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentContent;
    private String commentAuthor;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

}
