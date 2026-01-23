package com.UniversityDigitalRecordSystem;

import java.util.*;

public class Records {

    static class Node {
        int roll;
        String name;
        Node left, right;

        Node(int roll, String name) {
            this.roll = roll;
            this.name = name;
        }
    }

    static Node root;

    static Node insert(Node root, int roll, String name) {
        if (root == null) return new Node(roll, name);

        if (roll < root.roll)
            root.left = insert(root.left, roll, name);
        else if (roll > root.roll)
            root.right = insert(root.right, roll, name);

        return root;
    }

    static Node search(Node root, int roll) {
        if (root == null || root.roll == roll)
            return root;

        if (roll < root.roll)
            return search(root.left, roll);

        return search(root.right, roll);
    }

    static Node delete(Node root, int roll) {
        if (root == null) return null;

        if (roll < root.roll)
            root.left = delete(root.left, roll);
        else if (roll > root.roll)
            root.right = delete(root.right, roll);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            Node succ = root.right;
            while (succ.left != null)
                succ = succ.left;

            root.roll = succ.roll;
            root.name = succ.name;

            root.right = delete(root.right, succ.roll);
        }
        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.roll + " -> " + root.name);
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        root = insert(root, 103, "Aayush");
        root = insert(root, 101, "Rathour");
        root = insert(root, 105, "Rahul");

        Node found = search(root, 101);
        System.out.println(found != null ? "Found: " + found.name : "Not Found");

        root = delete(root, 103);

        System.out.println("Sorted Roll Numbers:");
        inorder(root);
    }
}
