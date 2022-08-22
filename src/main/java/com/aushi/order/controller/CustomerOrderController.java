package com.aushi.order.controller;

import com.aushi.order.entities.CustomerOrder;
import com.aushi.order.service.CustomerOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-orders")
@Slf4j
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @PostMapping("/")
    public CustomerOrder saveCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        log.info("Inside saveCustomerOrder method of CustomerOrderController");
        return customerOrderService.saveCustomerOrder(customerOrder);
    }

    @GetMapping("/{id}")
    public CustomerOrder findCustomerOrderById(@PathVariable("id") Long orderId){
        log.info("Inside findCustomerOrderById method of CustomerOrderController");
        return customerOrderService.findCustomerByOrderId(orderId);
    }
}
