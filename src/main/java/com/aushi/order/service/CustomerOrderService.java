package com.aushi.order.service;

import com.aushi.order.entities.CustomerOrder;
import com.aushi.order.repository.CustomerOrderRepository;
import com.aushi.order.vo.Customer;
import com.aushi.order.vo.CustomerOrderResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository, RestTemplate restTemplate) {
        this.customerOrderRepository = customerOrderRepository;
        this.restTemplate = restTemplate;
    }

    public CustomerOrder findCustomerOrderById(Long customerOrderId) {
        log.info("Inside findCustomerByOrderId method of CustomerOrderService");
        return customerOrderRepository.findCustomerOrderById(customerOrderId);
    }

    public CustomerOrder saveOrder(CustomerOrder customerOrder) {
        log.info("Inside saveOrder method of CustomerOrderService");
        return customerOrderRepository.save(customerOrder);
    }

    public CustomerOrderResponseTemplateVO getCustomerOrderWithCustomer(Long customerId) {
        log.info("Inside CustomerOrderResponseTemplateVO method of CustomerOrderService");
        CustomerOrderResponseTemplateVO customerOrderResponseTemplateVO = new CustomerOrderResponseTemplateVO();
        CustomerOrder customerOrder = customerOrderRepository.findCustomerOrderById(customerId);

        Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customers/" + customerId, Customer.class);

        customerOrderResponseTemplateVO.setCustomer(customer);
        customerOrderResponseTemplateVO.setCustomerOrder(customerOrder);

        return customerOrderResponseTemplateVO;
    }


}
