package com.pezesha.loans.controller;

import com.pezesha.loans.util.LoanRepaymentCalculator;
import com.pezesha.loans.util.LoanRepaymentSchedule;
import com.pezesha.loans.util.LoanRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanRepaymentController {

    @PostMapping("/calculate")
    public LoanRepaymentSchedule calculateRepaymentSchedule(@RequestBody LoanRequest request) {
        LoanRepaymentCalculator calculator = new LoanRepaymentCalculator();
        return calculator.calculateRepaymentSchedule(
                request.getLoanAmount(),
                request.getLoanTermMonths(),
                request.getInterestRate(),
                request.getRepaymentFrequency()
        );
    }
}