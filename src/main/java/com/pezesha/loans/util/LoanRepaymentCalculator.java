package com.pezesha.loans.util;

public class LoanRepaymentCalculator {

    public LoanRepaymentSchedule calculateRepaymentSchedule(
            double loanAmount,
            int loanTermMonths,
            double interestRate,
            RepaymentFrequency repaymentFrequency) {

        // Calculate the periodic interest rate and payment amount
        double periodicInterestRate = interestRate / ( repaymentFrequency.getNumPaymentsPerYear() * 100.0);
        double paymentAmount = calculatePaymentAmount(loanAmount, periodicInterestRate, loanTermMonths);

        // Create the repayment schedule
        LoanRepaymentSchedule repaymentSchedule = new LoanRepaymentSchedule(
                loanAmount, loanTermMonths, interestRate, repaymentFrequency);

        double balance = loanAmount;
        for (int i = 1; i <= loanTermMonths; i++) {
            double interest = balance * periodicInterestRate;
            double principal = paymentAmount - interest;
            balance = balance - principal;
            repaymentSchedule.addPayment(i, paymentAmount, principal, interest, balance);
        }

        return repaymentSchedule;
    }

    private double calculatePaymentAmount(double loanAmount, double periodicInterestRate, int loanTermMonths) {
        double numerator = loanAmount * periodicInterestRate * Math.pow(1 + periodicInterestRate, loanTermMonths);
        double denominator = Math.pow(1 + periodicInterestRate, loanTermMonths) - 1;
        return numerator / denominator;
    }
}
