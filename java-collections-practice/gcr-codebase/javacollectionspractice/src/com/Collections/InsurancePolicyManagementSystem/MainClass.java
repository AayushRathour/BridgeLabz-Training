package com.Collections.InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        InsurancePolicy p1 = new InsurancePolicy(101, "Aayush",
                LocalDate.now().plusDays(10), "Health", 5000);

        InsurancePolicy p2 = new InsurancePolicy(102, "Rathour",
                LocalDate.now().plusDays(40), "Auto", 7000);

        InsurancePolicy p3 = new InsurancePolicy(101, "Duplicate",
                LocalDate.now().plusDays(5), "Health", 6000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);

        manager.displayAllPolicies();
        manager.policiesExpiringSoon();
        manager.policiesByCoverage("Health");

        List<InsurancePolicy> list = Arrays.asList(p1, p2, p3);
        manager.findDuplicatePolicies(list);
    }
}
