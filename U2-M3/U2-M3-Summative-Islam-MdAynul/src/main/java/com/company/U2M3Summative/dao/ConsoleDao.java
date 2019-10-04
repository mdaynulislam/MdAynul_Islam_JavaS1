package com.company.U2M3Summative.dao;

import com.company.U2M3Summative.model.Console;

import java.util.List;

public interface ConsoleDao {
    //CRUD for Console

    Console addConsole(Console console);

    Console getConsole(int consoleId);

    List<Console> getAllConsoles();

    void updateConsole(Console console);

    void deleteConsole(int consoleId);

    //get Consoles by Manufacturer

    List<Console> getConsoleByManufacturer(String manufacturer);

}
