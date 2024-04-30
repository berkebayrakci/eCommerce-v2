package com.example.demo.service.concretes.orderItem;

import com.example.demo.entity.concretes.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import com.example.demo.service.abstracts.orderItem.OrderItemService;
import com.example.demo.service.dtos.OrderItemDTO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class OrderItemManager implements OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ModelMapper modelMapper;

    public OrderItemManager(OrderItemRepository orderItemRepository, ModelMapper modelMapper) {
        this.orderItemRepository = orderItemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderItemDTO getOrderItemById(Long id) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
        if (orderItemOptional.isPresent()) {
            return modelMapper.map(orderItemOptional.get(), OrderItemDTO.class);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order Item not found with " + id + " id"
            );
        }
    }

    @Override
    public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = modelMapper.map(orderItemDTO, OrderItem.class);
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return modelMapper.map(savedOrderItem, OrderItemDTO.class);
    }

    @Override
    public void updateOrderItem(Long id, OrderItemDTO orderItemDTO) {
        Optional<OrderItem> orderItemOptional = orderItemRepository.findById(id);
        if (orderItemOptional.isPresent()) {
            OrderItem orderItem = orderItemOptional.get();
            // Update order item properties here if needed
            orderItemRepository.save(orderItem);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order Item not found with " + id + " id"
            );
        }
    }

    @Override
    public void deleteOrderItem(Long id) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Order Item not found with " + id + " id"
            );
        }
    }
}
