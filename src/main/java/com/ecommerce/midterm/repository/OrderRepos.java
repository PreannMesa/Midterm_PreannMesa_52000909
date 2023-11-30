package com.ecommerce.midterm.repository;

import com.ecommerce.midterm.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepos extends JpaRepository<Order, Integer> {

}
