package com.dailyfoodrest.dailyfoodrest.repository;

import com.dailyfoodrest.dailyfoodrest.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("SELECT t FROM Food t WHERE t.recordActive = true ")
    List<Food> findAllActivated();

}
