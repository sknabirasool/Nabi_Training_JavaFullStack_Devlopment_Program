package org.java.example.debugandtrobleshoot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class AverageFromFile {
    public static void main(String[] args) {
        String filePath = "src/files/numbers.txt";
        double average = calculateAverage(filePath);
        System.out.println("The average is: " + average);
    }

    public static double calculateAverage(String filePath) {
        double sum = 0;
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    sum += Double.parseDouble(line);
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid number: " + line);
                }
            }
            if (count == 0) {
                System.out.println("No valid numbers found in the file.");
                return 0;
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return sum / count;
    }
}

