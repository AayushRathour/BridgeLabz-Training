package com.LoanBuddyLoanApprovalAutomation;

public class PersonalLoan extends LoanApplication {
    public PersonalLoan(int termInMonths) {
        super("Personal Loan", termInMonths, 0.015);
    }

    public boolean approveLoan(Applicant applicant) {
        boolean eligible = checkEligibility(applicant, 600, 15000);
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