package com.personalFinanceTracker.service;

import com.personalFinanceTracker.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface InterTransaction {
    Transaction createTransaction(Transaction transaction);

    List<Transaction> getAllTransactions();

    Optional<Transaction> getTransactionById(Long id);

    void deleteTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction);
}
