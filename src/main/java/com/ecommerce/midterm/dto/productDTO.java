package com.ecommerce.midterm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class productDTO {
    private Long id;
    private String name;
    private String category;
    private String brand;
    private String color;
    private double price;
    private boolean sale;
}
