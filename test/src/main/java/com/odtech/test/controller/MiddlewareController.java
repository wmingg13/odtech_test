package com.odtech.test.controller;

import com.odtech.test.entity.Customer;
import com.odtech.test.entity.OrderForm;
import com.odtech.test.entity.Transaction;
import com.odtech.test.misc.*;
import com.odtech.test.service.CustomerService;
import com.odtech.test.service.OrderFormService;
import com.odtech.test.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MiddlewareController {

    @Autowired
    private OrderFormService orderFormService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/order")
    public JsonResponse createOrder(@RequestBody OrderRequest json) {
        int count = 0;
        List<OrderForm> orderForm = json.getOrder();
        Customer customer = json.getCustomer();
        List<OrderForm> createdOrderForm = new ArrayList<OrderForm>();
        for(OrderForm obj : orderForm){
            obj.setCustomerId(customer.getCustomerId());
            createdOrderForm.add(orderFormService.createOrder(obj));
            count += 1;
        }
        Transaction transaction = transactionService.createTransaction();

        JsonResponse jsonResp = new JsonResponse();
        Meta metadata = new Meta();
        if (!createdOrderForm.isEmpty()){
            transaction = transactionService.updateTransactionStatus(transaction, "INPROGRESS", null);
            metadata.setCode(200);
            metadata.setRecordCount(count);
            jsonResp.setMeta(metadata);
            jsonResp.setTransaction(transaction);
            jsonResp.setOrderForm(createdOrderForm);
        }
        else{
            metadata.setCode(500);
            jsonResp.setMeta(metadata);
        }
        return jsonResp;
    }

    @GetMapping("/user")
    public JsonResponse retrieveUser(@RequestBody UserRequest userRequest){
        JsonResponse jsonResponse = new JsonResponse();
        Meta metadata = new Meta();
        // Perform data initialization here
        // Although I know there's way to perform pre-data initializing before bringing up the applications
        // But I not sure how to do it.
        customerService.init();
        Customer customer = customerService.getCustomerByIdentification(userRequest.getIdType(), userRequest.getIdNumber());

        metadata.setCode(200);
        jsonResponse.setMeta(metadata);
        jsonResponse.setCustomer(customer);

        return jsonResponse;
    }

    @PostMapping("/order/search")
    public JsonResponse searchOrder(@RequestBody OrderSearchRequest orderSearchRequest){
        JsonResponse jsonResponse = new JsonResponse();
        Meta metadata = new Meta();

        return jsonResponse;
    }

    @PutMapping("/order/{trxId}/status")
    public JsonResponse updateTrxStatus (@PathVariable("trxId") Long trxId, @RequestBody TransactionRequest transactionRequest){
        JsonResponse jsonResponse = new JsonResponse();
        Meta metadata = new Meta();

        Transaction transaction = transactionService.findById(trxId);

        Transaction updatedTrx = transactionService.updateTransactionStatus(transaction, transactionRequest.getStatus(), transactionRequest.getRemarks());

        metadata.setCode(200);

        jsonResponse.setMeta(metadata);
        jsonResponse.setTransaction(updatedTrx);

        return jsonResponse;
    }

}
