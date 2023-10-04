package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;


public class ManageDDT extends CommonOps {

    /**
     * DataProvider method that retrieves test data from a CSV file.
     *
     * @return A 2D array containing test data.
     */
    @DataProvider(name = "data-provider")
    public Object[][] getDataObject() {

        // Calls a method to retrieve data from a CSV file and return it as a 2D array
        return getDataFromCSV(getData("DDTFile"));
    }


    /**
     * Reads the contents of a CSV file and returns them as a list of strings.
     * get String of The path to the CSV file.
     * return A list of strings containing the lines from the CSV file.
     */
    public static List<String> readCSV(String csvFile) {
        List<String> lines = null; // Initialize a list of strings to store the lines from the CSV file
        File file = new File(csvFile); // Create a File object representing the CSV file
        try {
            // Read all lines from the CSV file using UTF-8 encoding
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            // If an IOException occurs during file reading, print the stack trace
            e.printStackTrace();
        }
        return lines; // Return the list of strings (lines from the CSV file)
    }

    /**
     * Reads data from a CSV file and formats it into a 2D array.
     * get a string of filePath The path to the CSV file.
     * return A 2D array containing the formatted data.
     */
    public static Object[][] getDataFromCSV(String filePath) {
        // Initialize a 2D array to hold the data (assuming a fixed size of 3x3)
        Object[][] data = new Object[3][3];
        List<String> csvData = readCSV(filePath); // Read data from CSV file and store in a list
        for (int i = 0; i < csvData.size(); i++) {
            // Split each line of CSV data using the delimiter ",,," and assign to respective elements in the 2D array
            data[i][0] = csvData.get(i).split(",,,")[0];
            data[i][1] = csvData.get(i).split(",,,")[1];
            data[i][2] = csvData.get(i).split(",,,")[2];

            System.out.println("user: " + data[i][0]);
            System.out.println("password: " + data[i][1]);
            System.out.println("expected message: " + data[i][2]);
            System.out.println("==================================");
        }
        return data; // Return the formatted 2D array
    }
}


