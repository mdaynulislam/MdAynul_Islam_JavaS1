package com.company.U2M3Summative.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    public static void main(String[] args) {

        PasswordEncoder enc = new BCryptPasswordEncoder();

        //keeping the password simple but in real case it won't be like this
        String staffPassword ="staff";
        String managerPassword="manager";
        String adminPassword= "admin";

        String staffPW= enc.encode(staffPassword);
        String managerPW= enc.encode(managerPassword);
        String adminPW= enc.encode(adminPassword);

        System.out.println("staff password " +staffPW);
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("manager password " +managerPW);
        System.out.println("------------------------------------------------");
        System.out.println("------------------------------------------------");
        System.out.println("admin password " +adminPW);

    }
}
