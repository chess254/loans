package com.pezesha.loans.util;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
@Disabled
public class LoanRepaymentScheduleTest {

    @Test
    public void testLoanRepaymentSchedule() {
        double loanAmount = 10000.00;
        int loanTermMonths = 12;
        double interestRate = 5.0;
        RepaymentFrequency repaymentFrequency = RepaymentFrequency.MONTHLY;

        LoanRepaymentSchedule schedule = new LoanRepaymentSchedule(loanAmount, loanTermMonths, interestRate, repaymentFrequency);

        // Add payments
        double monthlyInterestRate = interestRate / 100 / repaymentFrequency.getNumPaymentsPerYear();
        double paymentAmount = loanAmount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));
        double balance = loanAmount;

        for (int month = 1; month <= loanTermMonths; month++) {
            double interest = balance * monthlyInterestRate;
            double principal = paymentAmount - interest;
            balance -= principal;

            schedule.addPayment(month, paymentAmount, principal, interest, balance);
        }

        // Test results
        List<LoanRepayment> repayments = schedule.getRepayments();

        Assertions.assertEquals(12, repayments.size());

        Assertions.assertEquals(856.07, repayments.get(0).getPaymentAmount(), 0.01);
        Assertions.assertEquals(814.41, repayments.get(0).getPrincipal(), 0.01);
        Assertions.assertEquals(41.67, repayments.get(0).getInterest(), 0.01);
        Assertions.assertEquals(9185.59, repayments.get(0).getBalance(), 0.01);

        Assertions.assertEquals(856.07, repayments.get(11).getPaymentAmount(), 0.01);
        Assertions.assertEquals(852.52, repayments.get(11).getPrincipal(), 0.01);
        Assertions.assertEquals(3.55, repayments.get(11).getInterest(), 0.01);
        Assertions.assertEquals(0.00, repayments.get(11).getBalance(), 0.01);

        Assertions.assertEquals(10272.84, schedule.getTotalPaymentAmount(), 0.01);
        Assertions.assertEquals(10000.00, schedule.getTotalPrincipal(), 0.01);
        Assertions.assertEquals(272.89, schedule.getTotalInterest(), 0.01);
    }
}
