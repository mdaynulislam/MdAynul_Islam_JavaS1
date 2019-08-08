package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TelevisionReader {

    public static void main(String[] args) {


        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            int screen=60;
            System.out.println("All " + tvList + " Television has more than 60 inches screen size ");
            tvList
                    .stream()
                    .filter(b -> b.getScreenSize()>=screen)
                    .forEach(tv -> {
                        System.out.println("===============");

                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Price: " + tv.getPrice());
                        System.out.println("ScreenSize: " + tv.getScreenSize());
                    });

            //Grouping the TV by brand
            Map<String, List<Television>> groupedTv =
                    tvList
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));

            Set<String> keys = groupedTv.keySet();
            for(String key : keys) {
                System.out.println(key);
            }

            // Print the average screen size of the TV in inventory
            double avgScreenSize =
                    tvList
                            .stream()
                            .mapToInt(b -> b.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("Average Screen size is: " + avgScreenSize);

            // Maximum screen size of the TV

            int maxScreenSize =
                    tvList
                            .stream()
                            .mapToInt(t -> t.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("Maximum screen size is : " + maxScreenSize);


//            List<Television> sortedTvList = tvList
//                    .stream()
//                    .sorted(t->tvList.getScreenSize(n1,n2){if(n1>n2)}<Television>com).collect(Collectors.toList());
//            System.out.println(" The sorted TV are: " +sortedTvList);
//
//
//
//            sortedTvList.forEach(System.out::println);



                        } catch (JsonParseException e) {
                            e.printStackTrace();
                        } catch (JsonMappingException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {

                            }

    }


}
