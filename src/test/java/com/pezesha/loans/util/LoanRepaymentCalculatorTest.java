//package com.pezesha.loans.util;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class LoanRepaymentCalculatorTest {
//    @Disabled
//    @Test
//    public void testCalculateRepaymentSchedule() {
//        LoanRepaymentCalculator calculator = new LoanRepaymentCalculator();
//
//        // Test case 1
//        double loanAmount1 = 100000;
//        int loanTermMonths1 = 10;
//        double interestRate1 = 5.5;
//        RepaymentFrequency repaymentFrequency1 = RepaymentFrequency.MONTHLY;
//
//        LoanRepaymentSchedule schedule1 = calculator.calculateRepaymentSchedule(
//                loanAmount1, loanTermMonths1, interestRate1, repaymentFrequency1);
//
//
//        assertEquals(10253.81, schedule1.getRepayments().get(0).getPaymentAmount(), 0.01);
//        assertEquals(2538.13, schedule1.getTotalInterest(), 0.01);
//        assertEquals(0, schedule1.getRepayments().get(9).getBalance(), 0.01);
//        assertEquals(90204.52, schedule1.getRepayments().get(0).getBalance(), 0.01);
//
//
//
//    }
//}
