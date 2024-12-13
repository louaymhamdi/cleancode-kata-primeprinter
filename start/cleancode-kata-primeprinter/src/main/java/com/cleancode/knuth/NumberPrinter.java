package com.cleancode.knuth;

public class NumberPrinter {
    private final int linesPerPage; // Lines per page
    private final int columns; // Columns per page

    public NumberPrinter(int linesPerPage, int columns) {
        this.linesPerPage = linesPerPage;
        this.columns = columns;
    }

    public void printNumbers(int[] numbers, int numberOfNumbers) {
        int pageNumber = 1; // Current page number
        int pageOffset = 1; // Starting index for the current page

        while (pageOffset <= numberOfNumbers) {
            // Print page header
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pageNumber));
            System.out.println("\n");

            // Print rows and columns of numbers
            for (int rowOffset = pageOffset; rowOffset <= pageOffset + linesPerPage - 1; rowOffset++) {
                for (int column = 0; column <= columns - 1; column++) {
                    if (rowOffset + column * linesPerPage <= numberOfNumbers) {
                        System.out.printf("%10d", numbers[rowOffset + column * linesPerPage]);
                    }
                }
                System.out.println(); // New line after each row
            }
            System.out.println("\f"); // Page break
            pageNumber++; // Increment page number
            pageOffset += linesPerPage * columns; // Move to the next page
        }
    }
}
