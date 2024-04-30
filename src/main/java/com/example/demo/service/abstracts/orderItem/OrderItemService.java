package com.example.demo.service.abstracts.orderItem;

import com.example.demo.service.dtos.OrderItemDTO;

public interface OrderItemService {
    OrderItemDTO getOrderItemById(Long id);
    OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO);
    void updateOrderItem(Long id, OrderItemDTO orderItemDTO);
    void deleteOrderItem(Long id);
}
