package com.pluralsight;

// Import necessary Java I/O and utility classes for file operations and data structures
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class PayrollCalculator {
    public static void main(String[] args) {
        // Initialize a list to store Employee objects
        List<Employee> employees = new ArrayList<>();

        // Create Scanner object for user input
        Scanner in = new Scanner(System.in);

        try {
            // Prompt user for input and output file names
            System.out.print("Enter the name of the payroll file to create: ");
            String employee_file = in.next();

            System.out.print("Enter the name of the file employee file to process: ");
            String payroll_file = in.next();

            // Set up file reader with buffering for efficient reading
            // Reads from the resources directory
            FileReader fileReader = new FileReader("src/main/resources/" + employee_file);
            BufferedReader bufreader = new BufferedReader(fileReader);

            // Set up file writer with buffering for efficient writing
            // Writes to the resources directory
            FileWriter fileWriter = new FileWriter("src/main/resources/" + payroll_file);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            // Variable to store each line from the input file
            String input;

            // Process the file line by line
            while((input = bufreader.readLine()) != null) {
                // Split each line by pipe character
                // Example format: "id|name|hours|rate"
                String[] employee = input.split("\\|");

                // Skip the header row that contains column names
                if(employee[0].equals("id")) {
                    continue;
                }

                // Ensure we have all required employee data (4 fields)
                if(employee.length == 4) {
                    // Parse employee data from the split string array
                    int employee_id = Integer.parseInt(employee[0]);
                    String name = employee[1];
                    double hours_worked = Double.parseDouble(employee[2]);
                    double payRate = Double.parseDouble(employee[3]);

                    // Calculate gross pay (hours * rate)
                    double grossPay = Double.parseDouble(employee[2]) * Double.parseDouble(employee[3]);

                    // Create new Employee object with parsed data
                    Employee emp = new Employee(employee_id, name, hours_worked, payRate);

                    // Add employee to the list
                    employees.add(emp);

                    // Write employee payroll information to output file
                    // Format: "id,name,grossPay"
                    bufWriter.write(employee_id + "," + name + "," + grossPay + "\n");
                }
            }

            // Close file handlers to free up system resources
            bufWriter.close();
            bufreader.close();
        }
        // Handle any IO exceptions that might occur during file operations
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}