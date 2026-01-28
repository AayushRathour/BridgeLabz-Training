package com.annotations;

import java.util.ArrayList;

public class SupressUncheckedWarnings {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Java");
        list.add(10);                   

        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}

