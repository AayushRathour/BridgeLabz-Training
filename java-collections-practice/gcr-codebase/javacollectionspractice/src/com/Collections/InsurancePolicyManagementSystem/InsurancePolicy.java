package com.Collections.InsurancePolicyManagementSystem;

import java.time.LocalDate;

public class InsurancePolicy implements Comparable<InsurancePolicy> {

    int policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public InsurancePolicy(int policyNumber, String policyHolderName,
                           LocalDate expiryDate, String coverageType,
                           double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy other = (InsurancePolicy) obj;
        return this.policyNumber == other.policyNumber;
    }

    public int hashCode() {
        return Integer.hashCode(policyNumber);
    }

    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    public String toString() {
        return policyNumber + " | " + policyHolderName + " | " +
               expiryDate + " | " + coverageType + " | " + premiumAmount;
    }
}
