package com.ecommerce.midterm.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();

}
