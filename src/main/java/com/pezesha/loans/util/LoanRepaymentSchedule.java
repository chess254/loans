package com.pezesha.loans.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Data
@Getter
@Setter
public class LoanRepaymentSchedule {

    private double loanAmount;
    private int loanTermMonths;
    private double interestRate;
    private RepaymentFrequency repaymentFrequency;
    private List<LoanRepayment> repayments;

    public LoanRepaymentSchedule(double loanAmount, int loanTermMonths, double interestRate,
                                 RepaymentFrequency repaymentFrequency) {
        this.loanAmount = loanAmount;
        this.loanTermMonths = loanTermMonths;
        this.interestRate = interestRate;
        this.repaymentFrequency = repaymentFrequency;
        this.repayments = new ArrayList<>();
    }

    public void addPayment(int month, double paymentAmount, double principal, double interest, double balance) {
        LoanRepayment repayment = new LoanRepayment(month, paymentAmount, principal, interest, balance);
        repayments.add(repayment);
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String currencySymbol = Currency.getInstance(Locale.getDefault()).getSymbol();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Loan amount: %s%s\n", currencySymbol, df.format(loanAmount)));
        sb.append(String.format("Loan term: %d months\n", loanTermMonths));
        sb.append(String.format("Interest rate: %.2f%%\n", interestRate));
        sb.append(String.format("Repayment frequency: %s\n", repaymentFrequency));
        sb.append("\n");

        sb.append("Month     Payment Amount      Principal         Interest        Balance\n");
        sb.append("--------------------------------------------------------------\n");

        for (LoanRepayment repayment : repayments) {
            sb.append(String.format("%-10d%-20s%-20s%-20s%-20s\n",
                    repayment.getMonth(),
                    currencySymbol + df.format(repayment.getPaymentAmount()),
                    currencySymbol + df.format(repayment.getPrincipal()),
                    currencySymbol + df.format(repayment.getInterest()),
                    currencySymbol + df.format(repayment.getBalance())));
        }

        sb.append("--------------------------------------------------------------\n");
        sb.append(String.format("%-10s%-20s%-20s%-20s%-20s\n",
                "",
                currencySymbol + df.format(getTotalPaymentAmount()),
                currencySymbol + df.format(getTotalPrincipal()),
                currencySymbol + df.format(getTotalInterest()),
                ""));

        return sb.toString();
    }

    public double getTotalPaymentAmount() {
        double sum = repayments.stream().mapToDouble(LoanRepayment::getPaymentAmount).sum();
        BigDecimal bd = new BigDecimal(Double.toString(sum));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

    public double getTotalPrincipal() {
        return repayments.stream().mapToDouble(LoanRepayment::getPrincipal).sum();
    }

    public double getTotalInterest() {
        return repayments.stream().mapToDouble(LoanRepayment::getInterest).sum();
    }
}
