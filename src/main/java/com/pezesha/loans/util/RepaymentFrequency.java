package com.pezesha.loans.util;

public enum RepaymentFrequency {

    MONTHLY(12),
    BIMONTHLY(6),
    WEEKLY(52);

    private int numPaymentsPerYear;

    RepaymentFrequency(int numPaymentsPerYear) {
        this.numPaymentsPerYear = numPaymentsPerYear;
    }

    public int getNumPaymentsPerYear() {
        return numPaymentsPerYear;
    }
}
