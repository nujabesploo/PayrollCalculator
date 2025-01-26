package com.pluralsight;

import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class PayrollCalculator {

    public static void main(String[] args) {


        List<Employee> employees = new ArrayList<Employee>();
        

        
        try {


            FileReader filereader = new FileReader("src/main/resources/employees.csv");
            BufferedReader buffreader = new BufferedReader(filereader);
            
            String input;


            
            while((input = buffreader.readLine())!= null)
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



            for(Employee emp: employees)
            {

                System.out.printf("%d|%s|%.2f|%.2f%n", emp.getEmployeeId(), emp.getName(), emp.getHoursWorked(), emp.getPayRate());
            }

        }

        
        buffreader.close();
   
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }



}
