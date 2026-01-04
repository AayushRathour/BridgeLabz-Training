package com.StacksAndQueues.SortStackUsingRecursion;

import java.util.Stack;

public class MainClass {
    public static void main(String[] args) {

        Stack<Integer> st = new Stack<>();

        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        SortStack.sort(st);

        while (!st.isEmpty())
            System.out.print(st.pop() + " ");
    }

}
