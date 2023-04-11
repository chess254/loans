package com.pezesha.loans.util;

import lombok.Getter;
import lombok.Setter;

import java.math.RoundingMode;

import static java.math.BigDecimal.*;

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
        this.paymentAmount = valueOf(paymentAmount).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.principal = valueOf(principal).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.interest = valueOf(interest).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.balance = valueOf(balance).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // Getters and setters omitted for brevity
}