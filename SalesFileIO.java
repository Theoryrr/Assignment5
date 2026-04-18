import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Assignment 5 - SalesFileIO. This class reads sales data from a text file into a ragged 2D array and writes a formatted summary report to an output file.
 * Due: 04/20/2026
 * Platform/compiler: Mac / Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import java.util.Scanner;

public class SalesFileIO {

    /* readSalesData: reads file into ragged 2D array */
    public static double[][] readSalesData(String filename) throws FileNotFoundException {

        Scanner scan = new Scanner(new File(filename));

        int rows = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            if (!line.equals("")) rows++;
        }
        scan.close();

        double[][] data = new double[rows][];

        scan = new Scanner(new File(filename));
        int r = 0;

        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            if (line.equals("")) continue;

            String[] parts = line.split("\\s+");
            data[r] = new double[parts.length];

            for (int c = 0; c < parts.length; c++) {
                data[r][c] = Double.parseDouble(parts[c]);
            }

            r++;
        }

        scan.close();
        return data;
    }

    /* writeSummary: writes results to output file */
    public static void writeSummary(String filename, double[][] data) throws FileNotFoundException {

        PrintWriter out = new PrintWriter(new File(filename));

        out.println("Total sales: " + String.format("%.2f", SalesDataUtility.getTotal(data)));
        out.println("Average sale: " + String.format("%.2f", SalesDataUtility.getAverage(data)));

        for (int r = 0; r < data.length; r++) {
            out.println("Row " + r + " total: " + String.format("%.2f", SalesDataUtility.getRowTotal(data, r)));
        }

        int maxCols = 0;
        for (int r = 0; r < data.length; r++) {
            if (data[r].length > maxCols) maxCols = data[r].length;
        }

        for (int c = 0; c < maxCols; c++) {
            out.println("Column " + c + " total: " + String.format("%.2f", SalesDataUtility.getColumnTotal(data, c)));
        }

        out.println("Highest sale: " + String.format("%.2f", SalesDataUtility.getHighestInArray(data)));
        out.println("Lowest sale: " + String.format("%.2f", SalesDataUtility.getLowestInArray(data)));

        out.close();
    }
}