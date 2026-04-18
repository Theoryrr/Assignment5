/*
 * Class: CMSC203
 * Instructor: Grigoriy Grinberg
 * Description: Assignment 5 - SalesAppFX. This is the JavaFX GUI that loads an input sales file, displays computed results, and saves a summary output file.
 * Due: 04/20/2026
 * Platform/compiler: Mac / Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: William Binder
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SalesAppFX extends Application {

    private TextField tfInputFile;
    private TextField tfOutputFile;
    private TextArea taOutput;
    private double[][] currentData;

    public void start(Stage stage) {

        tfInputFile = new TextField("salesdata.txt");
        tfOutputFile = new TextField("sales_summary.txt");
        taOutput = new TextArea();
        taOutput.setEditable(false);

        Button btnLoad = new Button("Load & Process");
        Button btnSave = new Button("Save Summary");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.add(new Label("Input File:"), 0, 0);
        grid.add(tfInputFile, 1, 0);
        grid.add(new Label("Output File:"), 0, 1);
        grid.add(tfOutputFile, 1, 1);

        HBox buttons = new HBox(10, btnLoad, btnSave);
        VBox root = new VBox(10, grid, buttons, taOutput);
        root.setPadding(new Insets(10));

        btnLoad.setOnAction(e -> loadData());
        btnSave.setOnAction(e -> saveSummary());

        stage.setTitle("Store Sales Data Processor");
        stage.setScene(new Scene(root, 650, 450));
        stage.show();
    }

    private void loadData() {
        taOutput.clear();
        String inFile = tfInputFile.getText().trim();

        try {
            currentData = SalesFileIO.readSalesData(inFile);

            taOutput.appendText("Total sales: " + String.format("%.2f", SalesDataUtility.getTotal(currentData)) + "\n");
            taOutput.appendText("Average sale: " + String.format("%.2f", SalesDataUtility.getAverage(currentData)) + "\n");

            for (int r = 0; r < currentData.length; r++) {
                taOutput.appendText("Row " + r + " total: " + String.format("%.2f", SalesDataUtility.getRowTotal(currentData, r)) + "\n");
            }

            int maxCols = 0;
            for (int r = 0; r < currentData.length; r++) {
                if (currentData[r].length > maxCols) maxCols = currentData[r].length;
            }

            for (int c = 0; c < maxCols; c++) {
                taOutput.appendText("Column " + c + " total: " + String.format("%.2f", SalesDataUtility.getColumnTotal(currentData, c)) + "\n");
            }

            taOutput.appendText("Highest sale: " + String.format("%.2f", SalesDataUtility.getHighestInArray(currentData)) + "\n");
            taOutput.appendText("Lowest sale: " + String.format("%.2f", SalesDataUtility.getLowestInArray(currentData)) + "\n");

        } catch (Exception ex) {
            taOutput.appendText("ERROR: " + ex.getMessage() + "\n");
        }
    }

    private void saveSummary() {
        if (currentData == null) {
            taOutput.appendText("No data loaded. Load & Process first.\n");
            return;
        }

        String outFile = tfOutputFile.getText().trim();

        try {
            SalesFileIO.writeSummary(outFile, currentData);
            taOutput.appendText("Summary written to " + outFile + "\n");
        } catch (Exception ex) {
            taOutput.appendText("ERROR: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}