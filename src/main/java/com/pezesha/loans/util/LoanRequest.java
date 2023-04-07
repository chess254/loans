package com.pezesha.loans.util;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class LoanRequest {

    private double loanAmount;
    private int loanTermMonths;
    private double interestRate;
    private RepaymentFrequency repaymentFrequency;

    // Getters and setters omitted for brevity
}

