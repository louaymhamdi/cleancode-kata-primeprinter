package com.cleancode.knuth;

public class PrimePrinter {
    private static final int numberOfPrimes = 1000;

    public static void main(String[] args) {
        PrimePrinterHelper helper = new PrimePrinterHelper();
        int[] primes = helper.generatePrimes();
        helper.printNumbers(primes, numberOfPrimes);
    }
}