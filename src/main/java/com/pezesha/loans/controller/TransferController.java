package com.pezesha.loans.controller;

import com.pezesha.loans.models.Transaction;
import com.pezesha.loans.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Transaction> transferMoney(@RequestParam Long sourceAccountId, @RequestParam Long destinationAccountId, @RequestParam BigDecimal amount) {
        Transaction transaction = transferService.transferMoney(sourceAccountId, destinationAccountId, amount);
        return ResponseEntity.created(URI.create("/transactions/" + transaction.getId()))
                .body(transaction);
    }

}
