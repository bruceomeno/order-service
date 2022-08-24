package com.aushi.order.vo;

import com.aushi.order.entities.CustomerOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderResponseTemplateVO {

    private Customer customer;
    private CustomerOrder customerOrder;
}
