package com.SmartShelfRealTimeBookArrangement;

import java.util.*;
public class Book {
	public static void main(String[] args) {

		String[] book = {"Java", "Python", "Ruby", "CPP", "C"};
		String newBook = "Kotlin";
		System.out.println("Before: " + Arrays.toString(book));
		book[book.length - 1] = newBook;

		

		for (int i = 1; i < book.length; i++) {
			String key = book[i];
			int j = i - 1;

			while (j >= 0 && book[j].compareTo(key) > 0) {
				book[j + 1] = book[j];
				j--;
			}
			book[j + 1] = key;
		}

		System.out.println("Books Arranged in Series after adding  : " + Arrays.toString(book));
	}
}
