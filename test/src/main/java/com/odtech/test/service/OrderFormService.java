package com.odtech.test.service;

import com.odtech.test.entity.OrderForm;
import com.odtech.test.repository.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFormService {

    @Autowired
    private OrderFormRepository orderFormRepository;

    public OrderForm createOrder(OrderForm orderForm) {
        return orderFormRepository.save(orderForm);
    }

    public boolean findOrderById(Long orderId) {
        return orderFormRepository.findByOrderId(orderId);
    }

    public Integer findOrderCountByCustomerId(Long id) {
        return orderFormRepository.findOrderCountByCustomerId(id);
    }
}
