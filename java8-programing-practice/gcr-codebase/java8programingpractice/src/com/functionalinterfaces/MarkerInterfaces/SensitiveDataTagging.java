package com.functionalinterfaces.MarkerInterfaces;

interface SensitiveData {
}

class BankAccount implements SensitiveData {

    String accountNo = "12345";
}

public class SensitiveDataTagging {
    public static void main(String[] args) {

        BankAccount b = new BankAccount();

        if(b instanceof SensitiveData)
            System.out.println("Encrypt this data");
        else
            System.out.println("Normal data");
    }
}
