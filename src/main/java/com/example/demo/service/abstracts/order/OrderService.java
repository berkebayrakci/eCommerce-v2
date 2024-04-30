package com.example.demo.service.abstracts.order;

import com.example.demo.service.dtos.OrderDTO;

public interface OrderService {
    OrderDTO getOrderById(Long id);
    OrderDTO createOrder(OrderDTO orderDTO);
    void updateOrder(Long id, OrderDTO orderDTO);
    void deleteOrder(Long id);
    void adjustPricesForOrders();
}
