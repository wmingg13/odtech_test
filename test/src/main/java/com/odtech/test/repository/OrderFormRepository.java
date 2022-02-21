package com.odtech.test.repository;

import com.odtech.test.entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFormRepository extends JpaRepository<OrderForm, OrderForm> {
    boolean findByOrderId(Long orderId);

    @Query(value="select count(*) from order where customer_id = :id", nativeQuery = true)
    Integer findOrderCountByCustomerId(Long id);
}
