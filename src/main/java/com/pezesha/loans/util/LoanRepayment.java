package com.pezesha.loans.util;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
public class LoanRepayment {

    private int month;
    private double paymentAmount;
    private double principal;
    private double interest;
    private double balance;


//    DecimalFormat df = new DecimalFormat("#0.00");
//    BigDecimal bd = new BigDecimal(Double.toString(number));
//    bd = bd.setScale(2, RoundingMode.HALF_UP);

    public LoanRepayment(int month, double paymentAmount, double principal, double interest, double balance) {
        this.month = month;
//        this.paymentAmount = Double.parseDouble(df.format(paymentAmount));
//        this.principal = Double.parseDouble(df.format(principal));
//        this.interest = Double.parseDouble(df.format(interest));
//        this.balance = Double.parseDouble(df.format(balance));
        this.paymentAmount = new BigDecimal(paymentAmount).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.principal = new BigDecimal(principal).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.interest = new BigDecimal(interest).setScale(2, RoundingMode.HALF_UP).doubleValue();
        this.balance = new BigDecimal(balance).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // Getters and setters omitted for brevity
}