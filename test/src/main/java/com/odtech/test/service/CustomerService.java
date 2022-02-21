package com.odtech.test.service;

import com.odtech.test.entity.Contact;
import com.odtech.test.entity.Customer;
import com.odtech.test.entity.Detail;
import com.odtech.test.entity.Identification;
import com.odtech.test.repository.ContactRepository;
import com.odtech.test.repository.CustomerRepository;
import com.odtech.test.repository.DetailRepository;
import com.odtech.test.repository.IdentificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private IdentificationRepository identificationRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private DetailRepository detailRepository;


    public Customer getCustomerByIdentification(String idType, String idNumber) {
        Long customerId = identificationRepository.findById(idType, idNumber);
        return customerRepository.findByCustomerId(customerId);
    }

    public void init() {
        Customer customer1 = new Customer();

        Detail detail1 = new Detail();
        detail1.setDisplayName("John Doe");
        detail1.setDateOfBirth("1990-09-01");
        detail1.setEmail("test@test.com");
        customer1.setDetail(detail1);
        detail1.setCustomer(customer1);

        Identification identification1 = new Identification();
        identification1.setIdType("NEWNRIC");
        identification1.setIdNumber("900101-10-9943");
        customer1.setIdentification(identification1);
        identification1.setCustomer(customer1);

        Customer addedCustomer1 = customerRepository.save(customer1);


        Contact contact1 = new Contact();
        contact1.setType("PHONE");
        contact1.setValue("012-12345678");
        contact1.setCustomer(addedCustomer1);
        contactRepository.save(contact1);

        Contact contact2 = new Contact();
        contact2.setType("EMAIL");
        contact2.setValue("test@test.com");
        contact2.setCustomer(addedCustomer1);
        contactRepository.save(contact2);

    }
}
