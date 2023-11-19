package com.sparta.todolist.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CardViewAllResponseDto {
    private List<cardDto> elList = new ArrayList<>();
    public void add(Long cardId, String cardTitle, String userName, LocalDateTime cardCreatedAt, boolean completion){
        elList.add(new cardDto(
                cardId,
                cardTitle,
                userName,
                cardCreatedAt,
                completion
        ));
    }

    @Getter
    private static class cardDto {
        private Long cardId;
        private String cardTitle;
        private String userName;
        private LocalDateTime cardCreatedAt;
        private boolean completion;

        public cardDto(Long cardId, String cardTitle, String userName, LocalDateTime cardCreatedAt, boolean completion) {
            this.cardId = cardId;
            this.cardTitle = cardTitle;
            this.userName = userName;
            this.cardCreatedAt = cardCreatedAt;
            this.completion = completion;
        }
    }
}
