package ru.itpark.mcdonalds.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductEntity {
    private int id;
    private String name;
    private int price;
    private String description;
    private String img;
}
