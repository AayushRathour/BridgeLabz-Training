package com.SearchingAlgorithm.StringBuffer;

public class StringBufferVsStringBuilder {
    public static void main(String[] args) {

        int val = 1000000;

        long startBuffer = System.nanoTime();
        StringBuffer RathourBuffer = new StringBuffer();
        for (int i = 0; i < val; i++) {
            RathourBuffer.append("hello");
        }
        long endBuffer = System.nanoTime();

        long startBuilder = System.nanoTime();
        StringBuilder RathourBuilder = new StringBuilder();
        for (int i = 0; i < val; i++) {
            RathourBuilder.append("hello");
        }
        long endBuilder = System.nanoTime();

        System.out.println("StringBuffer Time (ns): " + (endBuffer - startBuffer));
        System.out.println("StringBuilder Time (ns): " + (endBuilder - startBuilder));
    }
}
