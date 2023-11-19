package com.sparta.todolist.controller;

import com.sparta.todolist.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sparta.todolist.service.CardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/card")
    public CardCreateResponseDto createCard(@RequestBody CardCreateRequestDto cardCreateRequestDto){
        return cardService.createCard(cardCreateRequestDto);
    }

    @GetMapping("/cards/{cardId}")
    public CardViewResponseDto viewCard(@PathVariable Long cardId){
        return cardService.viewCard(cardId);
    }

    @GetMapping("/cards")
    public ResponseEntity<CardViewAllResponseDto> viewAllCard(){
        return ResponseEntity.ok(cardService.viewAllCard());
    }

    @PatchMapping("/cards/{cardId}")
    public CardEditResponseDto editCard(@PathVariable Long cardId, @RequestBody CardEditRequestDto cardEditRequestDto){
        return cardService.editCard(cardId, cardEditRequestDto);
    }

    @DeleteMapping("/cards/{cardId}")
    public void deleteCard(@PathVariable Long cardId){
        cardService.deleteCard(cardId);
    }

    @PostMapping("/cards/done/{cardId}")
    public void updateCardCompletion(@PathVariable Long cardId){
        cardService.updateCardCompletion(cardId);
    }
}
