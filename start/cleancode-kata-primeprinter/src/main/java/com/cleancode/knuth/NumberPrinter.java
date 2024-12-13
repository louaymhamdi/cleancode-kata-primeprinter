package com.cleancode.knuth;

public class NumberPrinter {
    private final int linesPerPage;
    private final int columns;

    public NumberPrinter(int linesPerPage, int columns) {
        this.linesPerPage = linesPerPage;
        this.columns = columns;
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