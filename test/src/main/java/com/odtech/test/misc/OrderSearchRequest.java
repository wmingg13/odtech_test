package com.odtech.test.misc;

import com.odtech.test.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderSearchRequest {

    private Customer customer;
    
}
