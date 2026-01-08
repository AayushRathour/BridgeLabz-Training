package com.LoanBuddyLoanApprovalAutomation;

public class HomeLoan extends LoanApplication {
    public HomeLoan(int termInMonths) {
        super("Home Loan", termInMonths, 0.008);
    }

    public boolean approveLoan(Applicant applicant) {
        boolean eligible = checkEligibility(applicant, 700, 30000);
        setApproved(eligible);
        return eligible;
    }

    public double calculateEMI(Applicant applicant) {
        double P = applicant.getLoanAmount();
        double R = interestRate;
        int N = termInMonths;
        return (P * R * Math.pow(1 + R, N)) / (Math.pow(1 + R, N) - 1);
    }
}