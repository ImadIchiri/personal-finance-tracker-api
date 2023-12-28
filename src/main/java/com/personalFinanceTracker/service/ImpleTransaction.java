package com.personalFinanceTracker.service;

import com.personalFinanceTracker.model.Transaction;
import com.personalFinanceTracker.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpleTransaction implements InterTransaction {

    @Autowired
    private TransactionRepo transactionRepo;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepo.findById(id);
    }

    public void deleteTransaction(Transaction transaction) {
        transactionRepo.delete(transaction);
    }

    public Transaction updateTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }
}
