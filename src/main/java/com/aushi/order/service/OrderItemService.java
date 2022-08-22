package com.aushi.order.service;

import com.aushi.order.entities.OrderItem;
import com.aushi.order.repository.OrderItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem saveOrderItem(OrderItem orderItem) {
        log.info("Inside saveOrderItem method of OrderItemService");
        return orderItemRepository.save(orderItem);
    }

    public OrderItem findOrderItemById(Long orderItemId) {
        log.info("Inside findOrderItemById method of OrderItemService");
        return orderItemRepository.findById(orderItemId).orElseThrow(() -> new RuntimeException("Result not found"));
    }
}
