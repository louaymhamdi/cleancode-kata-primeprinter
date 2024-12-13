package com.cleancode.knuth;

public class PrimePrinterHelper {
    private static final int ordmax = 30;

    private final int[] primes = new int[1001];
    private final int[] multiples = new int[ordmax + 1];

    private int candidate = 1;
    private int primeIndex = 1;
    private int ord = 2;
    private int square = 9;

    public int[] generatePrimes() {
        primes[1] = 2;

        while (primeIndex < 1000) {
            boolean possiblyPrime;
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                int n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate) {
                        multiples[n] += primes[n] + primes[n];
                    }
                    if (multiples[n] == candidate) {
                        possiblyPrime = false;
                    }
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;
        }
        return primes;
    }
}
