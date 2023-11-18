package entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.TypeAlias;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private String cardTitle;
    private String cardContent;
    private String cardAuthor;
    @CreatedDate
    private LocalDateTime cardCreatedAt;
    private boolean isCompletion;

    @OneToMany(mappedBy = "card")
    private List<Comment> commentList;
}
