package com.example.demo.service.concretes.order;

import com.example.demo.entity.concretes.HistoricalPrice;
import com.example.demo.entity.concretes.Order;
import com.example.demo.entity.concretes.OrderItem;
import com.example.demo.entity.concretes.Product;
import com.example.demo.repository.HistoricalPriceRepository;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.abstracts.order.OrderService;
import com.example.demo.service.abstracts.product.ProductService;
import com.example.demo.service.dtos.OrderDTO;
import com.example.demo.service.dtos.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderManager implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;
    private final HistoricalPriceRepository historicalPriceRepository;
    private final ModelMapper modelMapper;

    public OrderManager(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductService productService, HistoricalPriceRepository historicalPriceRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productService = productService;
        this.historicalPriceRepository = historicalPriceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            return modelMapper.map(orderOptional.get(), OrderDTO.class);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order not found with " + id + " id"
            );
        }
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        Order savedOrder = orderRepository.save(order);
        return modelMapper.map(savedOrder, OrderDTO.class);
    }

    @Override
    public void updateOrder(Long id, OrderDTO orderDTO) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            // Update order properties here if needed
            orderRepository.save(order);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order not found with " + id + " id"
            );
        }
    }

    @Override
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order not found with " + id + " id"
            );
        }
    }

    public void adjustPricesForOrders() {
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            for (OrderItem orderItem : order.getOrderItems()) {
                ProductDTO productDTO = productService.getProductById(orderItem.getProduct().getId());
                Long currentPrice = productDTO.getPrice();
                if (!orderItem.getPrice().equals(currentPrice)) {
                    orderItem.setPrice(currentPrice);
                    orderItemRepository.save(orderItem);

                    HistoricalPrice historicalPrice = new HistoricalPrice();
                    historicalPrice.setProductId(orderItem.getProduct().getId());
                    historicalPrice.setPrice(currentPrice);
                    historicalPrice.setTimestamp(LocalDateTime.now());
                    historicalPriceRepository.save(historicalPrice);
                }
            }
        }
    }
}
