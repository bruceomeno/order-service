package com.aushi.order.service;

import com.aushi.order.entities.CustomerOrder;
import com.aushi.order.repository.CustomerOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder) {
        log.info("Inside saveCustomerOrder method of CustomerOrderService");
        return customerOrderRepository.save(customerOrder);
    }

    public CustomerOrder findCustomerByOrderId(Long orderId) {
        log.info("Inside findCustomerByOrderId method of CustomerOrderService");
        return customerOrderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Result not found"));
    }
}
