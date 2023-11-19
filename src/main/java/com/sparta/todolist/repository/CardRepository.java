package com.sparta.todolist.repository;

import com.sparta.todolist.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
