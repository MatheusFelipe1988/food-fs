package com.fs.cardapio.entity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodRepository extends JpaRepository<Food, Long> {
}
