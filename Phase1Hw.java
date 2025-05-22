//Joshua Guzman August 22, 2023 
/*Java program that does a simple evaluation for the data types of values in a file. This Java program
will be able to automatically generate SQL insert statements */

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Phase1Hw {
    public static void main(String[] args) {
        
        try {
            //Create a file to write results to   
            FileWriter outputfile = new FileWriter("phase1Results.txt");

            //Read the txt file
            File infile = new File("phase1_fall2023-1.txt");
            Scanner input = new Scanner(infile);

            while (input.hasNextLine()) {
                String line =  input.nextLine();
                ArrayList<String> outputList = new ArrayList<>();

                // Split line on commas
                String[] values = line.split(",");

                for (String value : values) {
                    value = value.trim(); // Remove whitespace

                    try {
                        // Try to parse as integer
                        Integer.parseInt(value);
                        outputList.add("Integer");
                    } catch (NumberFormatException e1) { 
                        try {
                            // Try to parse as float
                            Float.parseFloat(value);
                            outputList.add("Float");
                        } catch (NumberFormatException e2) {
                            // Else, it's a string
                            outputList.add("String");
                        }
                    }
                }

                // Generate output string
                String outputString = String.join(", ", outputList);

                // Write output string to output file
                outputfile.write(outputString + "\n");
            }

            // Close file writer and scanner
            outputfile.close();
            input.close();

        } catch (FileNotFoundException e) {
            //Need to catch FNFE for FileWriter and Scanner
            System.out.println(e.getMessage());
        }
          catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
