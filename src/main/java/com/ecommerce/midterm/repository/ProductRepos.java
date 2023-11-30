package com.ecommerce.midterm.repository;

import com.ecommerce.midterm.model.Product;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
@Repository
public interface ProductRepos extends JpaRepository<Product, Integer> {
    List<Product> getAllProducts();
    List<Product> searchProducts(String category, String name, String brand, String color);
    Product getProductById(Long id);

    List<Product> searchProductsByString(SingularAttribute<AbstractPersistable, Serializable> keyword);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    List<Product> searchProductsByString(String keyword);
}
