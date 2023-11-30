package com.ecommerce.midterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String brand;
    private String color;
    private double price;
    private boolean sale;

    public boolean getSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }
}
