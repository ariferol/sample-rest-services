package com.dailyfoodrest.dailyfoodrest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FOODS")
public class Food extends ModelBase {
    @Id
    @GeneratedValue(generator = "food_generator")
    @SequenceGenerator(
            name = "food_generator",
            sequenceName = "food_sequence",
            initialValue = 1
    )
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @Column(nullable = false)
    private Date foodDate;

    @Column()
    private float calorie;

    @Column(nullable = false)
    private String foodDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFoodDate() {
        return foodDate;
    }

    public void setFoodDate(Date foodDate) {
        this.foodDate = foodDate;
    }

    public float getCalorie() {
        return calorie;
    }

    public void setCalorie(float calorie) {
        this.calorie = calorie;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }
}