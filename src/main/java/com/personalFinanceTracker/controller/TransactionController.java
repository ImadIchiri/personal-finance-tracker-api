package com.personalFinanceTracker.controller;

import com.personalFinanceTracker.model.Transaction;
import com.personalFinanceTracker.service.InterTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    
    @Autowired
    InterTransaction transactionService;

    @GetMapping("")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> geTransactionById(@PathVariable Long id) {
        Optional<Transaction> optTransaction = transactionService.getTransactionById(id);

        if (optTransaction.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optTransaction.get(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @PutMapping("/{id}/edit")
    public Transaction editTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        if (id != transaction.getId()) {
            return new ResponseEntity<>(
                    "Request Error: id on the the path not equal to the one on the Request Body !",
                    HttpStatus.OK);
        }

        transactionService.deleteTransaction(transaction);
        return new ResponseEntity<>("Transaction Deleted !", HttpStatus.OK);
    }

}
