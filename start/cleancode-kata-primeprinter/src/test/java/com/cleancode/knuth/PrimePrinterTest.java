package com.cleancode.knuth;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimePrinterTest {
    private PrintStream out; // Backup for the original System.out

    @BeforeEach
    void setup() throws Exception {
        // Redirect System.out to a file (lead.txt) for test output
        out = System.out;
        System.setOut(new PrintStream(new FileOutputStream("lead.txt")));
    }

    @AfterEach
    void teardown() {
        // Restore the original System.out and clean up test files
        System.out.close();
        System.setOut(out);
        new File("lead.txt").delete();
    }

    @Test
    void makeSureOutputMatchesGold() throws Exception {
        // Run the PrimePrinter and compare its output to a reference file (gold.txt)
        PrimePrinter.main(new String[0]);
        BufferedReader lead = null; // Reader for test output
        BufferedReader gold = null; // Reader for reference output
        try {
            lead = new BufferedReader(new FileReader("lead.txt"));
            gold = new BufferedReader(new FileReader("gold.txt"));
            String line;
            // Compare each line of the test output to the reference
            while ((line = gold.readLine()) != null)
                assertEquals(line, lead.readLine());
            // Ensure no extra lines are present in the test output
            assertEquals(null, lead.readLine());
        } finally {
            // Close readers to release resources
            lead.close();
            gold.close();
        }
    }
}
