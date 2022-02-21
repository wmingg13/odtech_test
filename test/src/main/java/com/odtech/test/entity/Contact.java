package com.odtech.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(length=30)
    private String value;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="customer_id")
    private Customer customer;

}
