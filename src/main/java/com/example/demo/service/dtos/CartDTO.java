package com.example.demo.service.dtos;

import java.util.List;

public class CartDTO {
    private Long id;
    private Long customerId; // Assuming each cart belongs to a customer
    private List<OrderItemDTO> items;

    public CartDTO(Long id, Long customerId, List<OrderItemDTO> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
    }

    public CartDTO() {
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

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
