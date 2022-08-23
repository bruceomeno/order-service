package com.aushi.order.controller;

import com.aushi.order.entities.OrderItem;
import com.aushi.order.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order-items")
@Slf4j
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

@PostMapping("/")
    public OrderItem saveOrderItem(@RequestBody OrderItem orderItem){
        log.info("Inside saveOrderItem method of OrderItemController");
        return orderItemService.saveOrderItem(orderItem);
    }

    @GetMapping("/{id}")
    public OrderItem findOrderItemById(@PathVariable("id") Long orderItemId) {
        log.info("Inside findOrderItemById method of OrderItemController");
        return orderItemService.findOrderItemById(orderItemId);
    }
}
