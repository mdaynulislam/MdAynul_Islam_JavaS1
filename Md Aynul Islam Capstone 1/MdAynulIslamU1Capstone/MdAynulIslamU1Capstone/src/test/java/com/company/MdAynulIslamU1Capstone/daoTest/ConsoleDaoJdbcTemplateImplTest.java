package com.company.MdAynulIslamU1Capstone.daoTest;

import com.company.MdAynulIslamU1Capstone.dao.ConsoleDao;
import com.company.MdAynulIslamU1Capstone.model.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {

    @Autowired
    ConsoleDao consoleDao;


    @Before
    public void setUp() throws Exception{
        //deleting the consoles in the Data base

        List<Console> consoleList = consoleDao.getAllConsoles();
        for(Console cs: consoleList){
            consoleDao.deleteConsole(cs.getConsoleId());
        }
    }

    @Test
    public void addGetDeleteConsole(){

        //without the id it's a PK
        Console console=new Console();

        console.setModel("Matrix");
        console.setManufacturer("Matrix Man");
        console.setMemoryAmount("500MB");
        console.setProcessor("G7");
        console.setPrice(new BigDecimal("25.99"));
        console.setQuantity(50);

        console=consoleDao.addConsole(console);

        Console console1=consoleDao.getConsole(console.getConsoleId());

        assertEquals(console1,console);

        consoleDao.deleteConsole(console.getConsoleId());
        console1=consoleDao.getConsole(console.getConsoleId());

        assertNull(console1);

    }

    @Test
    public void getAllConsoles(){
        //populating first console
        Console console=new Console();

        console.setModel("Matrix");
        console.setManufacturer("Matrix Man");
        console.setMemoryAmount("500MB");
        console.setProcessor("G7");
        console.setPrice(new BigDecimal("25.99"));
        console.setQuantity(50);

        console=consoleDao.addConsole(console); // adding to the DAO

        //populating 2nd console
         console=new Console();

        console.setModel("Matrix2");
        console.setManufacturer("Matrix Ultimate");
        console.setMemoryAmount("450MB");
        console.setProcessor("G8");
        console.setPrice(new BigDecimal("39.99"));
        console.setQuantity(50);

        consoleDao.addConsole(console); //adding the second console

        //passing all the consoles in a list
        List<Console> consoleList=consoleDao.getAllConsoles();
        //comparing the list which should have 2 console in it
        assertEquals(2,consoleList.size());

    }

    @Test
    public void updateConsole(){

        //populating console
        Console console=new Console();

        console.setModel("Matrix");
        console.setManufacturer("Matrix Man");
        console.setMemoryAmount("500MB");
        console.setProcessor("G7");
        console.setPrice(new BigDecimal("25.99"));
        console.setQuantity(50);

        console=consoleDao.addConsole(console); // adding the first console

        console.setModel("Matrix updated");
        console.setManufacturer("Matrix Man updated");
        console.setMemoryAmount("450MB");
        console.setProcessor("G8");
        console.setPrice(new BigDecimal("39.99"));
        console.setQuantity(50);

        consoleDao.updateConsole(console);

        Console console1=consoleDao.getConsole(console.getConsoleId()); // adding the updated console in console1
        assertEquals(console,console1);

    }

    @Test
    public void getConsoleByManufacturer(){
        //populating the console

        Console console=new Console();

        console.setModel("Matrix");
        console.setManufacturer("Matrix Man");
        console.setMemoryAmount("500MB");
        console.setProcessor("G7");
        console.setPrice(new BigDecimal("25.99"));
        console.setQuantity(50);

        console=consoleDao.addConsole(console); // adding the console to dao

         console=new Console();

        console.setModel("Matrix2");
        console.setManufacturer("Matrix Man");
        console.setMemoryAmount("400MB");
        console.setProcessor("G9");
        console.setPrice(new BigDecimal("35.99"));
        console.setQuantity(50);

        console=consoleDao.addConsole(console); // adding the 2nd console

        //passing the 2 console in a List
        List<Console> byManufacturer=consoleDao.getConsoleByManufacturer("Matrix Man");

        assertEquals(byManufacturer.size(),2);// same Manufacturer have two console

        byManufacturer=consoleDao.getConsoleByManufacturer("Fake"); //doesn't exist
        assertEquals(byManufacturer.size(),0);

    }


}
