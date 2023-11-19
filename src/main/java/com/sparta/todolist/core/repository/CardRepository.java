package com.sparta.todolist.core.repository;

import com.sparta.todolist.core.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

}
