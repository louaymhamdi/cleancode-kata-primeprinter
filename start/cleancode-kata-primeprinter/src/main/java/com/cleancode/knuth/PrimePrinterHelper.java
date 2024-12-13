package com.cleancode.knuth;

public class PrimePrinterHelper {
    private static final int ordmax = 30; // Maximum order for sieving primes

    private final int[] primes = new int[1001]; // Array to store prime numbers
    private final int[] multiples = new int[ordmax + 1]; // Array to track multiples of primes

    private int candidate = 1; // Current number being tested for primality
    private int primeIndex = 1; // Index of the last found prime
    private int ord = 2; // Current order of sieving
    private int square = 9; // Square of the smallest prime to check

    /**
     * Generates the first 1000 prime numbers using a modified sieve algorithm.
     *
     * @return Array of prime numbers.
     */
    public int[] generatePrimes() {
        primes[1] = 2; // The first prime number is 2

        while (primeIndex < 1000) {
            boolean possiblyPrime;
            do {
                candidate += 2; // Increment candidate by 2 to test only odd numbers
                if (candidate == square) {
                    // Move to the next order when reaching the square of the current prime
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                int n = 2; // Start checking multiples from the second prime
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    // Update multiples until they are greater than or equal to the candidate
                    while (multiples[n] < candidate) {
                        multiples[n] += primes[n] + primes[n];
                    }
                    // If candidate matches a multiple, it is not a prime
                    if (multiples[n] == candidate) {
                        possiblyPrime = false;
                    }
                    n++;
                }
            } while (!possiblyPrime); // Repeat until a prime is found
            primeIndex++;
            primes[primeIndex] = candidate; // Store the found prime
        }
        return primes;
    }
}
