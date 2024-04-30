package com.example.demo.entity.concretes;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "historicalPrice")
public class HistoricalPrice {
    public HistoricalPrice() {
    }

    public HistoricalPrice(Long id, Long productId, Long price, LocalDateTime timestamp) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.timestamp = timestamp;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;
    @Column(name = "price")
    private Long price;
    @Column(name = "time_stamp")
    private LocalDateTime timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
