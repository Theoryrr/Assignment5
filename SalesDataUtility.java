/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Assignment 5 - SalesDataUtility. This class contains static methods that process a ragged 2D double array to calculate totals, averages, and highest/lowest values.
 * Due: 04/20/2026
 * Platform/compiler: Mac / Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

public class SalesDataUtility {

    public static double getTotal(double[][] data) {
        double total = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                total += data[r][c];
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                total += data[r][c];
                count++;
            }
        }

        if (count == 0) return 0;
        return total / count;
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (int c = 0; c < data[row].length; c++) {
            total += data[row][c];
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (int r = 0; r < data.length; r++) {
            if (col < data[r].length) {
                total += data[r][col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double highest = data[row][0];
        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] > highest) highest = data[row][c];
        }
        return highest;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double lowest = data[row][0];
        for (int c = 1; c < data[row].length; c++) {
            if (data[row][c] < lowest) lowest = data[row][c];
        }
        return lowest;
    }

    public static double getHighestInArray(double[][] data) {
        double highest = data[0][0];
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] > highest) highest = data[r][c];
            }
        }
        return highest;
    }

    public static double getLowestInArray(double[][] data) {
        double lowest = data[0][0];
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                if (data[r][c] < lowest) lowest = data[r][c];
            }
        }
        return lowest;
    }
}