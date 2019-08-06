package com.company;
import com.opencsv.CSVReader;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class CSVWriteAndRead {

    public static void main(String[] args) {


        PrintWriter writer = null;


        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));


        CSVReader reader = null;
        String[] currentCells = new String[0];
        String[] headings = new String[0];

        try {

            // Now let's write the motorcycle list to another file
             writer = new PrintWriter(new FileWriter("new_car.csv"));
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

            beanToCsv.write(carList);
            writer.close();


            //READING PORTION
            //READING PORTION

            reader = new CSVReader(new FileReader("new_car.csv"));

            // Read the first line (if it exists) - this is the header row.  We'll print out the headers
            headings = reader.readNext();
            if (headings != null) {
                for (String heading : headings) {
                    System.out.println(heading);
                }
            }

            while ((currentCells = reader.readNext()) != null) {
                System.out.println("=====================================");
                for (int i = 0; i < currentCells.length; i++) {
                    System.out.println(headings[i] + " : " + currentCells[i]);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());


        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
