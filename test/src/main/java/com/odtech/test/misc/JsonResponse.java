package com.odtech.test.misc;

import com.odtech.test.entity.Customer;
import com.odtech.test.entity.OrderForm;
import com.odtech.test.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponse {
    private Meta meta;
    private Customer customer;
    private Transaction transaction;
    private List<OrderForm> orderForm;
}
