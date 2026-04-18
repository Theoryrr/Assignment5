/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Assignment 5 - SalesAppDriver. This is the console driver that prompts for input and output file names, processes the sales data, and writes the summary file.
 * Due: 04/20/2026
 * Platform/compiler: Mac / Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */ java.util.Scanner;

public class SalesAppDriver {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter input file name: ");
        String inputFile = keyboard.nextLine().trim();

        System.out.print("Enter output file name: ");
        String outputFile = keyboard.nextLine().trim();

        try {
            double[][] data = SalesFileIO.readSalesData(inputFile);
            SalesFileIO.writeSummary(outputFile, data);

            System.out.println("Summary written to " + outputFile);
            System.out.println("Programmer: William Binder");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Programmer: William Binder");
        }

        keyboard.close();
    }
}