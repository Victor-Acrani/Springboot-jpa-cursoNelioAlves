package com.acrani.course.services;

import com.acrani.course.entities.OrderEntity;
import com.acrani.course.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> findAll(){
        return orderRepository.findAll();
    }

    public OrderEntity findById(Long id){
        Optional<OrderEntity> order = orderRepository.findById(id);
        return order.get();
    }
}
