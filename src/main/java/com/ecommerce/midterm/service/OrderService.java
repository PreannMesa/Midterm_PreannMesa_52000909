package com.ecommerce.midterm.service;

import com.ecommerce.midterm.iservice.Iorder;
import com.ecommerce.midterm.model.Order;
import com.ecommerce.midterm.repository.OrderRepos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements Iorder {
    @Autowired
    private OrderRepos orderRepository;

    @Override
    public List<Order> selectAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Order> selectAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Order selectById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        if (orderRepository.existsById(id))
            orderRepository.deleteById(id);
        return !orderRepository.existsById(id);
    }

    @Override
    @Transactional
    public Order update(Order orderUpdate) {
        return orderRepository.save(orderUpdate);
    }
}
