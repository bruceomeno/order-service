package com.aushi.order.repository;

import com.aushi.order.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    CustomerOrder findCustomerOrderById(Long customerId);

}
