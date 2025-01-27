package com.pluralsight;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;


public class PayrollCalculator {

    public static void main(String[] args) {


        List<Employee> employees = new ArrayList<>();
        

        
        try {


            FileReader filereader = new FileReader("src/main/resources/employees.csv");
            BufferedReader bufreader = new BufferedReader(filereader);
            
            String input;


            
            while((input = bufreader.readLine())!= null)
            {
                String[] employee = input.split("\\|");

                if(employee[0].equals("id"))
                {

                    continue;
                }

                if(employee.length == 4)
                {
                    Employee emp = new Employee(Integer.parseInt(employee[0]), employee[1], Double.parseDouble(employee[2]), Double.parseDouble(employee[3]));

                    employees.add(emp);
                }

            }

            bufreader.close();


            for(Employee emp: employees)
            {

                System.out.printf("%d|%s|%.2f|%.2f%n", emp.getEmployeeId(), emp.getName(), emp.getHoursWorked(), emp.getPayRate());
            }

        }

        
        
   
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }



}
