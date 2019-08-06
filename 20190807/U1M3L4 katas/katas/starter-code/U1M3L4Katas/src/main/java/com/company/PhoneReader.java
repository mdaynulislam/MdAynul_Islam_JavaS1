package com.company;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {

    public static void main(String[] args) {

        try {
            XmlMapper mapper = new XmlMapper();

            List<Phone> phoneList;

            phoneList = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>() {
            });

            for (Phone ph : phoneList) {

                System.out.println("=============================");
                System.out.println(ph.getPrice());
                System.out.println(ph.getStorage());
                System.out.println(ph.getProcessor());
                System.out.println(ph.getBrand());
                System.out.println(ph.getModel());
            }


        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









