package com.example.demo.service.dtos;

import java.util.List;

public class OrderDTO {
    private Long id;
    private Long customerId;
    private Long totalAmount;
    private List<OrderItemDTO> items;

    public OrderDTO(Long id, Long customerId, Long totalAmount, List<OrderItemDTO> items) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
