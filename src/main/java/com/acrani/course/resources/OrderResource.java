package com.acrani.course.resources;

import com.acrani.course.entities.OrderEntity;
import com.acrani.course.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> findAll(){
        List<OrderEntity> allOrders = orderService.findAll();
        return ResponseEntity.ok().body(allOrders);

    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> findById(@PathVariable Long id){
        OrderEntity order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
