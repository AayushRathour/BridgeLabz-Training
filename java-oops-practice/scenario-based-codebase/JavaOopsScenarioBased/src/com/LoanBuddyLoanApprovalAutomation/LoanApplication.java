package com.LoanBuddyLoanApprovalAutomation;

public abstract class LoanApplication implements IApprovable {
    protected String loanType;
    protected int termInMonths;
    protected double interestRate;
    private boolean approved;

    public LoanApplication(String loanType, int termInMonths, double interestRate) {
        this.loanType = loanType;
        this.termInMonths = termInMonths;
        this.interestRate = interestRate;
        this.approved = false;
    }

    protected boolean checkEligibility(Applicant applicant, int minScore, double minIncome) {
        if(applicant.getCreditScore() >= minScore && applicant.getIncome() >= minIncome) {
            return true;
        }
        return false;
    }

    protected void setApproved(boolean status) {
        approved = status;
    }

    public boolean isApproved() {
        return approved;
    }
}