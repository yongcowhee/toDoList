package com.sparta.todolist.core.service;

import com.sparta.todolist.core.dto.*;
import com.sparta.todolist.core.entity.Card;
import com.sparta.todolist.core.entity.User;
import com.sparta.todolist.core.repository.CardRepository;
import com.sparta.todolist.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CardService {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    // 카드 생성
    public CardCreateResponseDto createCard (CardCreateRequestDto cardCreateRequestDto){
        User user = userRepository.findById(cardCreateRequestDto.getUserId()).orElseThrow(()->
                new IllegalArgumentException("존재하지 않는 유저입니다."));
        Card card = new Card(user, cardCreateRequestDto);
        CardCreateResponseDto cardCreateResponseDto = new CardCreateResponseDto(
                card.getCardTitle(), card.getCardContent());
        return cardCreateResponseDto;
    }

    // 선택 카드 조회
    public CardViewResponseDto viewCard (Long cardId){
        Card card = cardRepository.findById(cardId).orElseThrow(()->
                new IllegalArgumentException("존재하지 않는 할일카드 입니다."));
        CardViewResponseDto cardViewResponseDto = new CardViewResponseDto(
                card.getCardTitle(), card.getCardContent(), card.getUser().getUserName(), card.getCreatedAt()
        );
        return cardViewResponseDto;
    }

    // 전체 카드 조회
    public CardViewAllResponseDto viewAllCard(){
        List<Card> cardList = cardRepository.findAll();
        CardViewAllResponseDto cardViewAllResponseDto = new CardViewAllResponseDto();
        for (Card c : cardList) {
            cardViewAllResponseDto.add(c.getCardId(), c.getCardTitle(), c.getUser().getUserName(),
                    c.getCreatedAt(), c.getIsCompletion());
        }
        return cardViewAllResponseDto;
    }
    // 카드 수정
    public CardEditResponseDto editCard(Long cardId, CardEditRequestDto cardEditRequestDto){
        Card card = cardRepository.findById(cardId).orElseThrow(()->
                new IllegalArgumentException("존재하지 않는 할일카드 입니다."));
        card.editCard(cardEditRequestDto); // entity에 setter를 쓰는 건 좋지 않은 방법이므로 직접 수정하는 메서드 구현 및 호출
        cardRepository.save(card);
        return new CardEditResponseDto(
                card.getCardTitle(),
                card.getCardContent(),
                card.getUser().getUserName(),
                card.getCreatedAt()
        );
    }

    // 카드 삭제
    public void deleteCard(Long cardId){
        Card card = cardRepository.findById(cardId).orElseThrow(()->
                new IllegalArgumentException("존재하지 않는 할일카드 입니다."));
        cardRepository.delete(card);
    }

    public void updateCardCompletion(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(()->
                new IllegalArgumentException("존재하지 않는 할일카드 입니다."));
        card.updateCompletion();
        cardRepository.save(card);
    }
}
