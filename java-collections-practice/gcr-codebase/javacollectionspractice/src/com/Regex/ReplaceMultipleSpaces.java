package com.Regex;

public class ReplaceMultipleSpaces {
	public static void main(String[] args) {
        String input = "This   is   an    example   with  multiple spaces.";
        String output = input.replaceAll("[ ]+", " ");
        System.out.println(output);
    }
}