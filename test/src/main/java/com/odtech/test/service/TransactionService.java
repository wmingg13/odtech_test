package com.odtech.test.service;

import com.odtech.test.entity.Transaction;
import com.odtech.test.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    private final static String SUBMITTED = "SUBMITTED";
    private final static String INPROGRESS = "INPROGRESS";
    private final static String CANCELLED = "CANCELLED";
    private final static String EXCEPTION = "EXCEPTION";
    private final static String COMPLETED = "COMPLETED";

    private final static String SUBMITTED_DESC = "Submitted";
    private final static String INPROGRESS_DESC = "In progress";
    private final static String CANCELLED_DESC = "Cancelled";
    private final static String EXCEPTION_DESC = "Exception";
    private final static String COMPLETED_DESC = "Completed";

    public Transaction createTransaction() {
        Transaction transaction = new Transaction();
        transaction.setStatus(SUBMITTED);
        transaction.setStatusDesc(SUBMITTED_DESC);
        transaction.setCreated(new Date());
        transaction.setLastUpdated(new Date());
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransactionStatus(Transaction transaction, String status, String remarks){
        if(status.equals(SUBMITTED)){
            transaction.setStatus(SUBMITTED);
            transaction.setStatusDesc(SUBMITTED_DESC);
        }
        else if(status.equals(INPROGRESS)){
            transaction.setStatus(INPROGRESS);
            transaction.setStatusDesc(INPROGRESS_DESC);
        }
        else if(status.equals(CANCELLED)){
            transaction.setStatus(CANCELLED);
            transaction.setStatusDesc(CANCELLED_DESC);
        }
        else if(status.equals(EXCEPTION)){
            transaction.setStatus(EXCEPTION);
            transaction.setStatusDesc(EXCEPTION_DESC);
        }
        else if(status.equals(COMPLETED)){
            transaction.setStatus(COMPLETED);
            transaction.setStatusDesc(COMPLETED_DESC);
        }
        transaction.setRemarks(remarks);
        return transactionRepository.save(transaction);
    }

    public Transaction findById(Long trxId) {
        return transactionRepository.findByTransactionId(trxId);
    }
}
