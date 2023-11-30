package com.ecommerce.midterm.iservice;

import com.ecommerce.midterm.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Iorder  {
    List<Order> selectAll();
    Page<Order> selectAll(Pageable pageable);
    Order selectById(Integer id);
    Order insert(Order order);
    boolean deleteById(Integer id);
    Order update(Order orderUpdate);
}
