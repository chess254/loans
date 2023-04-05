package com.pezesha.loans.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanRepayment {

    private int month;
    private double paymentAmount;
    private double principal;
    private double interest;
    private double balance;

    public LoanRepayment(int month, double paymentAmount, double principal, double interest, double balance) {
        this.month = month;
        this.paymentAmount = paymentAmount;
        this.principal = principal;
        this.interest = interest;
        this.balance = balance;
    }

    // Getters and setters omitted for brevity
}