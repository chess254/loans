package com.pezesha.loans.service;

import com.pezesha.loans.exception.BadRequestException;
import com.pezesha.loans.models.Account;
import com.pezesha.loans.models.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountService accountService;
    private final TransactionService transactionService;

    public TransferService(AccountService accountService, TransactionService transactionService) {
        this.accountService = accountService;
        this.transactionService = transactionService;
    }

    //'@Transactional' for atomicity and 'synchronized' to avoid race conditions
    @Transactional
    public synchronized Transaction transferMoney(Long sourceAccountId, Long destinationAccountId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Transfer amount must be greater than zero");
        }
        Account sourceAccount = accountService.getAccount(sourceAccountId);
        Account destinationAccount = accountService.getAccount(destinationAccountId);
        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new BadRequestException("Insufficient funds");
        }
        if (amount.compareTo(sourceAccount.getBalance()) > 0)
            throw new BadRequestException("Insufficient funds");
        return transactionService.createTransaction(sourceAccount, destinationAccount, amount);
    }

}
