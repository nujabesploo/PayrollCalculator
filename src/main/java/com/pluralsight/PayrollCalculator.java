package com.pluralsight;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;


public class PayrollCalculator {

    public static void main(String[] args) {


        List<Employee> employees = new ArrayList<>();

        Scanner in  = new Scanner(System.in);

        
        try {

            System.out.print("Enter the name of the payroll file to create: ");
            String employee_file = in.next();

            System.out.print("Enter the name of the file employee file to process: ");
            String payroll_file = in.next();



            FileReader fileReader = new FileReader("src/main/resources/" + employee_file);
            BufferedReader bufreader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("src/main/resources/" + payroll_file);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            
            String input;


            while((input = bufreader.readLine()) != null)
            {
                String[] employee = input.split("\\|");

                if(employee[0].equals("id"))
                {

                    continue;
                }

                if(employee.length == 4)
                {
                    int employee_id = Integer.parseInt(employee[0]);
                    String name = employee[1];
                    double hours_worked = Double.parseDouble(employee[2]);
                    double payRate = Double.parseDouble(employee[3]);

                    double grossPay = Double.parseDouble(employee[2]) * Double.parseDouble(employee[3]);

                    Employee emp = new Employee(employee_id, name, hours_worked, payRate);

                    employees.add(emp);

                    // Write employee information to file
                    bufWriter.write(employee_id + "," + name + "," + grossPay + "\n");
                }

            }

            bufWriter.close();
            bufreader.close();

        }

   
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }



}
