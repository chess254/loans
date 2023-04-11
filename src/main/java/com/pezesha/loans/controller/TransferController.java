package com.pezesha.loans.controller;

import com.pezesha.loans.dto.TransferDto;
import com.pezesha.loans.models.Transaction;
import com.pezesha.loans.service.TransferService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/transfers")
@Slf4j
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Transaction> transferMoney(@RequestBody @Valid TransferDto transferDto) {
        Transaction transaction = transferService.transferMoney(transferDto.getSourceAccountId(),
                transferDto.getDestinationAccountId(),
                transferDto.getAmount()
        );
        if (transaction!=null)
            log.info("Transferred Money {} Kshs From Account: {} to Account: {} ",
                    transaction.getAmount(),
                    transaction.getSourceAccount().getId(),
                    transaction.getDestinationAccount().getId()
            );
        return ResponseEntity.created(URI.create("/transactions/" + transaction.getId()))
                .body(transaction);
    }

}
