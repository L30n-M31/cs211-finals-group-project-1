package reader;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class for reading data from a file.
 */
public class DataFileReader {
    /**
     * Constructs a new instance of DataFileReader
     */
    public DataFileReader() { } // end of constructor

    /**
     * Reads the contents of a file and returns the data as a list of strings.
     *
     * @param filename The name of the file to be read.
     * @return A list of strings representing the lines of the file.
     */
    public List<String> readFile(String filename) {
        List<String> data = new ArrayList<>();
        Scanner reader = null;
        try {
            reader = new Scanner(new File("Graph Data/" + filename));
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, "File Not Found");
            System.out.println("\nFile Not Found");
        }

        while (reader.hasNextLine()) {
            data.add(reader.nextLine());
        }
        return data;
    } // end of readFile
} // end of DataFileReader class
