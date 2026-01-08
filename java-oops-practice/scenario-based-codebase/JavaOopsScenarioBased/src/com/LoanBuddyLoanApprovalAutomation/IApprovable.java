package com.LoanBuddyLoanApprovalAutomation;

public interface IApprovable {
    boolean approveLoan(Applicant applicant);
    double calculateEMI(Applicant applicant);
