package com.cleancode.knuth;

public class PrimePrinterHelper {
    private static final int linesPerPage = 50;
    private static final int columns = 4;
    private static final int ordmax = 30;

    private final int[] primes = new int[1001]; // numberOfPrimes + 1
    private final int[] multiples = new int[ordmax + 1];

    private int candidate = 1;
    private int primeIndex = 1;
    private int ord = 2;
    private int square = 9;

    public int[] generatePrimes() {
        primes[1] = 2;

        while (primeIndex < 1000) { // Using direct value since numberOfPrimes is moved
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

    public void printNumbers(int[] numbers, int numberOfNumbers) {
        int pageNumber = 1;
        int pageOffset = 1;

        while (pageOffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pageNumber));
            System.out.println("\n");

            for (int rowOffset = pageOffset; rowOffset <= pageOffset + linesPerPage - 1; rowOffset++) {
                for (int column = 0; column <= columns - 1; column++) {
                    if (rowOffset + column * linesPerPage <= numberOfNumbers) {
                        System.out.printf("%10d", numbers[rowOffset + column * linesPerPage]);
                    }
                }
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += linesPerPage * columns;
        }
    }
}