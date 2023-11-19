package com.sparta.todolist.entity;

import com.sparta.todolist.dto.CardCreateRequestDto;
import com.sparta.todolist.dto.CardEditRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Card extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    @Getter
    private Long cardId;
    @Getter
    private String cardTitle;
    @Getter
    private String cardContent;
    @Getter
    private Boolean isCompletion;

    @OneToMany(mappedBy = "card")
    private List<Comment> commentList;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    private User user; // Author

    public Card(User user, CardCreateRequestDto cardCreateRequestDto) {
        this.user = user;
        this.cardTitle = cardCreateRequestDto.getCardTitle();
        this.cardContent = cardCreateRequestDto.getCardContent();
        this.isCompletion = false;
    }

    public void editCard(CardEditRequestDto cardEditRequestDto){
        this.cardTitle = cardEditRequestDto.getCardTitle();
        this.cardContent = cardEditRequestDto.getCardContent();
    }

    public void updateCompletion(){
        this.isCompletion = true;
    }
}
