package com.ecommerce.midterm.iservice;

import com.ecommerce.midterm.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface IProduct  {
    List<Product> selectAll();
    Page<Product> selectAll(Pageable pageable);
    Product selectById(Integer id);
    Product insert(Product product);
    boolean deleteById(Integer id);
    Product update(Product productUpdate);
    List<Product> searchProductByKeyword(String keyword);
    List<Product> findByPriceBetween(int index);
    List<Product> getProductsOnSale(List<Product> productList);
    List<Product> searchProductByAuthor(UUID keyword);
}
