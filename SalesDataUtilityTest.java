/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Assignment 5 - SalesDataUtilityTest. This class contains JUnit test methods to verify the SalesDataUtility calculations using known ragged arrays.
 * Due: 04/20/2026
 * Platform/compiler: Mac / Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SalesDataUtilityTest {

    @Test
    public void testGetTotal() {
        double[][] data = {
                {100.50, 200.75, 150.00},
                {80.00, 90.00},
                {220.10, 130.50, 300.00, 50.25}
        };
        assertEquals(1322.10, SalesDataUtility.getTotal(data), 0.01);
    }

    @Test
    public void testGetAverage() {
        double[][] data = {
                {100.50, 200.75, 150.00},
                {80.00, 90.00},
                {220.10, 130.50, 300.00, 50.25}
        };
        assertEquals(146.90, SalesDataUtility.getAverage(data), 0.01);
    }

    @Test
    public void testGetRowTotal() {
        double[][] data = {
                {5.0, 10.0},
                {2.5},
                {7.5, 1.0, 3.0}
        };
        assertEquals(15.00, SalesDataUtility.getRowTotal(data, 0), 0.01);
        assertEquals(2.50, SalesDataUtility.getRowTotal(data, 1), 0.01);
        assertEquals(11.50, SalesDataUtility.getRowTotal(data, 2), 0.01);
    }

    @Test
    public void testGetColumnTotal() {
        double[][] data = {
                {5.0, 10.0},
                {2.5},
                {7.5, 1.0, 3.0}
        };
        assertEquals(15.00, SalesDataUtility.getColumnTotal(data, 0), 0.01);
        assertEquals(11.00, SalesDataUtility.getColumnTotal(data, 1), 0.01);
        assertEquals(3.00, SalesDataUtility.getColumnTotal(data, 2), 0.01);
    }

    @Test
    public void testHighLowInArray() {
        double[][] data = {
                {-10.0, -5.0, -20.0},
                {30.0},
                {0.0, 15.0}
        };
        assertEquals(30.00, SalesDataUtility.getHighestInArray(data), 0.01);
        assertEquals(-20.00, SalesDataUtility.getLowestInArray(data), 0.01);
    }
}