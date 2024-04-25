package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<Order> getListUser(){
        return  orderRepository.findAll();
    }

    public Order getUserById(long id){
        return orderRepository.findById(id).get();
    }
}
