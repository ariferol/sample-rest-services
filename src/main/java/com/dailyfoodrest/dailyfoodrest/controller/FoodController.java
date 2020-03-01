package com.dailyfoodrest.dailyfoodrest.controller;

import com.dailyfoodrest.dailyfoodrest.model.Food;
import com.dailyfoodrest.dailyfoodrest.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/getfoods")
    public List<Food> getFoodList() {
        return foodRepository.findAllActivated();
    }

    @GetMapping("/getallfoods")
    public List<Food> getAllFoodList() {
        return foodRepository.findAll();
    }

    @GetMapping("/foods")
    public Page<Food> getFoods(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }


    @PostMapping("/insertfood")
    public Food insertFood(@Valid @RequestBody Food food) {
        return foodRepository.save(food);
    }

    @PostMapping("/insertfoods")
    public List<Food> insertFoods(@Valid @RequestBody List<Food> foods) {
        return foodRepository.saveAll(foods);
    }

    @PutMapping("/foods/{foodId}")
    public Food updateFood(@PathVariable Long foodId,
                                   @Valid @RequestBody Food fRequest) throws Exception {
        return foodRepository.findById(foodId)
                .map(f -> {
                    f.setFoodDate(fRequest.getFoodDate());
                    f.setCalorie(fRequest.getCalorie());
                    f.setFoodDescription(fRequest.getFoodDescription());
                    return foodRepository.save(f);
                }).orElseThrow(() -> new Exception("Food not found with id " + foodId));
    }


    @DeleteMapping("/foods/{foodId}")
    public ResponseEntity<?> deleteFood(@PathVariable Long foodId) throws Exception {
        return foodRepository.findById(foodId)
                .map(f -> {
                    foodRepository.delete(f);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new Exception("Question not found with id " + foodId));
    }
}
