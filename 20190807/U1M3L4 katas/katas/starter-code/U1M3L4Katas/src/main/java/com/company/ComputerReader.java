package com.company;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

public class ComputerReader {


    public static void main(String[] args) {

        try {
            List<Computer> compute =
                    new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();
            for (Computer comp : compute) {
                System.out.println("=================================");
                System.out.println(comp.getBrand());
                System.out.println(comp.getModel());
                System.out.println(comp.getCpu());
                System.out.println(comp.getRam());
                System.out.println(comp.getStorageSize());
                // Now let's write the motorcycle list to another file
                Writer writer = new FileWriter("computers.csv");
                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
                beanToCsv.write(compute);
                writer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        }
    }


}

