package com.aushi.order.controller;

import com.aushi.order.entities.CustomerOrder;
import com.aushi.order.service.CustomerOrderService;
import com.aushi.order.vo.CustomerOrderResponseTemplateVO;
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
    public CustomerOrder saveOrder(@RequestBody CustomerOrder customerOrder) {
        log.info("Inside saveOrder method of OrderItemController");
        return customerOrderService.saveOrder(customerOrder);
    }

    @GetMapping("/{id}")
    public CustomerOrderResponseTemplateVO getCustomerOrderWithCustomer(@PathVariable("id") Long customerId) {
        log.info("Inside getOrderWithCustomer method of OrderItemController");
        return customerOrderService.getCustomerOrderWithCustomer(customerId);
    }
}
