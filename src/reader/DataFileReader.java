package reader;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataFileReader {

    public DataFileReader() { } // end of constructor

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
