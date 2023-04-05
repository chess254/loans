package com.pezesha.loans.service;

import com.pezesha.loans.models.Account;
import com.pezesha.loans.models.Transaction;
import com.pezesha.loans.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction createTransaction(Account sourceAccount, Account destinationAccount,  BigDecimal amount) {
        LocalDateTime timestamp = LocalDateTime.now();
        sourceAccount.withdraw(amount);
        destinationAccount.deposit(amount);
        Transaction transaction = new Transaction(null, sourceAccount, destinationAccount, amount, timestamp);
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

}