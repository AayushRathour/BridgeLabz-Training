package com.Collections.InsurancePolicyManagementSystem;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    HashSet<InsurancePolicy> hashSet = new HashSet<>();
    LinkedHashSet<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    TreeSet<InsurancePolicy> treeSet = new TreeSet<>();

    void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        for (InsurancePolicy p : hashSet) {
            System.out.println(p);
        }
    }

    void policiesExpiringSoon() {
        System.out.println("Policies Expiring Within 30 Days:");
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);

        for (InsurancePolicy p : treeSet) {
            if (!p.expiryDate.isAfter(limit)) {
                System.out.println(p);
            }
        }
    }

    void policiesByCoverage(String type) {
        System.out.println("Policies with Coverage: " + type);
        for (InsurancePolicy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    void findDuplicatePolicies(List<InsurancePolicy> list) {
        HashSet<Integer> seen = new HashSet<>();
        System.out.println("Duplicate Policies:");
        for (InsurancePolicy p : list) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }
}
