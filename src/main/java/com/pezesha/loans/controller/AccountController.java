package com.pezesha.loans.controller;

import com.pezesha.loans.models.Account;
import com.pezesha.loans.service.AccountService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestParam @Positive(message = "You CAnnot create an account with 0 deposit") BigDecimal balance) {
        Account account = accountService.createAccount(balance);
        return ResponseEntity.created(URI.create("/accounts/" + account.getId()))
                .body(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> account = accountService.findAll();
        return ResponseEntity.ok()
                .body(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        Account account = accountService.getAccount(id);
        return ResponseEntity.ok(account);
    }

}

