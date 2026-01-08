package com.LoanBuddyLoanApprovalAutomation;

public class AutoLoan extends LoanApplication {
    public AutoLoan(int termInMonths) {
        super("Auto Loan", termInMonths, 0.010);
    }

    public boolean approveLoan(Applicant applicant) {
        boolean eligible = checkEligibility(applicant, 650, 20000);
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