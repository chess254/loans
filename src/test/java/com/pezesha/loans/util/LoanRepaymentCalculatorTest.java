package com.pezesha.loans.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoanRepaymentCalculatorTest {
    @Test
    public void testCalculateRepaymentSchedule() {
        LoanRepaymentCalculator calculator = new LoanRepaymentCalculator();

        // Test case 1
        double loanAmount1 = 100000;
        int loanTermMonths1 = 10;
        double interestRate1 = 5.5;
        RepaymentFrequency repaymentFrequency1 = RepaymentFrequency.MONTHLY;

        LoanRepaymentSchedule schedule1 = calculator.calculateRepaymentSchedule(
                loanAmount1, loanTermMonths1, interestRate1, repaymentFrequency1);

        assertEquals(592.12, schedule1.getPaymentAmount(), 0.01);
        assertEquals(592.12 * 10, schedule1.getTotalPayments(), 0.01);
        assertEquals(592.12 * 10 - 100000, schedule1.getTotalInterest(), 0.01);
        assertEquals(0, schedule1.getPayments().get(0).getBalance(), 0.01);
        assertEquals(52918.34, schedule1.getPayments().get(10).getBalance(), 0.01);

        // Test case 2
        double loanAmount2 = 50000;
        int loanTermMonths2 = 24;
        double interestRate2 = 10;
        RepaymentFrequency repaymentFrequency2 = RepaymentFrequency.BIMONTHLY;

        LoanRepaymentSchedule schedule2 = calculator.calculateRepaymentSchedule(
                loanAmount2, loanTermMonths2, interestRate2, repaymentFrequency2);

        assertEquals(2353.56, schedule2.getPaymentAmount(), 0.01);
        assertEquals(2353.56 * 24, schedule2.getTotalPayments(), 0.01);
        assertEquals(2353.56 * 24 - 50000, schedule2.getTotalInterest(), 0.01);
        assertEquals(0, schedule2.getPayments().get(0).getBalance(), 0.01);
        assertEquals(0, schedule2.getPayments().get(23).getBalance(), 0.01);

        // Test case 3
        double loanAmount3 = 75000;
        int loanTermMonths3 = 36;
        double interestRate3 = 8.75;
        RepaymentFrequency repaymentFrequency3 = RepaymentFrequency.WEEKLY;

        LoanRepaymentSchedule schedule3 = calculator.calculateRepaymentSchedule(
                loanAmount3, loanTermMonths3, interestRate3, repaymentFrequency3);

        assertEquals(601.45, schedule3.getPaymentAmount(), 0.01);
        assertEquals(601.45 * 36, schedule3.getTotalPayments(), 0.01);
        assertEquals(601.45 * 36 - 75000, schedule3.getTotalInterest(), 0.01);
        assertEquals(0, schedule3.getPayments().get(0).getBalance(), 0.01);
        assertEquals(0, schedule3.getPayments().get(35).getBalance(), 0.01);
    }

}
