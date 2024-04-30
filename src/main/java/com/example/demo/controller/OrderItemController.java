package com.example.demo.controller;

import com.example.demo.service.abstracts.orderItem.OrderItemService;
import com.example.demo.service.dtos.OrderItemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order-items")
public class OrderItemController {
    private final OrderItemService orderItemService;
    private final ModelMapper modelMapper;

    public OrderItemController(OrderItemService orderItemService, ModelMapper modelMapper) {
        this.orderItemService = orderItemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable Long id) {
        OrderItemDTO orderItemDTO = orderItemService.getOrderItemById(id);
        return ResponseEntity.ok(orderItemDTO);
    }

    @PostMapping
    public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        OrderItemDTO createdOrderItemDTO = orderItemService.createOrderItem(orderItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderItemDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrderItem(@PathVariable Long id, @RequestBody OrderItemDTO orderItemDTO) {
        orderItemService.updateOrderItem(id, orderItemDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
