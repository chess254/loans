package com.pezesha.loans.service;

import com.pezesha.loans.exception.BadRequestException;
import com.pezesha.loans.exception.NotFoundException;
import com.pezesha.loans.models.Account;
import com.pezesha.loans.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account createAccount(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Initial deposit must be greater than 0");
        }
        Account account = new Account(balance);
        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Account not found"));
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}


