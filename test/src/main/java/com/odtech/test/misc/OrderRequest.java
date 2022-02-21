package com.odtech.test.misc;

import com.odtech.test.entity.Customer;
import com.odtech.test.entity.OrderForm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Customer customer;
    private List<OrderForm> order;
}
