package com.aushi.order.service;

import com.aushi.order.entities.CustomerOrder;
import com.aushi.order.repository.OrderItemRepository;
import com.aushi.order.repository.CustomerOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final OrderItemRepository orderItemRepository;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository, OrderItemRepository orderItemRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public CustomerOrder findByOrderId(Long orderId) {
        log.info("Inside findCustomerByOrderId method of CustomerOrderService");
        return customerOrderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Result not found"));
    }

    public CustomerOrder saveOrder(CustomerOrder customerOrder) {
        log.info("Inside saveOrder method of CustomerOrderService");
        return customerOrderRepository.save(customerOrder);
    }
}
