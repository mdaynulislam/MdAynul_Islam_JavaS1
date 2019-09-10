package com.company.MdAynulIslamU1Capstone.daoTest;

import com.company.MdAynulIslamU1Capstone.dao.TShirtsDao;
import com.company.MdAynulIslamU1Capstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoJdbcTemplateTest {

    @Autowired
    TShirtsDao tShirtsDao;

    @Before
    public void setUp()throws Exception{
        //deleting the T-shirt from the Database

        List<TShirt> tShirtList = tShirtsDao.getAllTShirts();
        for(TShirt ts: tShirtList){
            tShirtsDao.deleteTShirt(ts.gettShirtId());
        }
    }

    @Test
    public void addGetDelete(){

        //populating T shirt without the id

        TShirt tShirt=new TShirt();

        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V neck");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(50);

        tShirt=tShirtsDao.addTShirt(tShirt); // adding the t shirt in dao

        TShirt tShirt1= tShirtsDao.getTShirt(tShirt.gettShirtId()); //passing the same t shirt into t shirt1

        //compare
        assertEquals(tShirt1,tShirt);

        tShirtsDao.deleteTShirt(tShirt.gettShirtId()); // deleting the t shirt
        tShirt1=tShirtsDao.getTShirt(tShirt.gettShirtId()); //passing the same deleted t shirt into t shirt1
         assertNull(tShirt1);
    }

    @Test
    public void getAllTShirt(){

        //populating the first T shirt without the id

        TShirt tShirt=new TShirt();

        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V neck");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(50);

        tShirt=tShirtsDao.addTShirt(tShirt); // adding the first t shirt

        //populating the 2nd t shirt

        //populating T shirt without the id

         tShirt=new TShirt();

        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V neck");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(50);

        tShirtsDao.addTShirt(tShirt); // 2nd t shirt added

        // passing the t shirts into a List
        List<TShirt> tShirtList =tShirtsDao.getAllTShirts();

        //comparing the list should have 2
        assertEquals(2,tShirtList.size());
    }

    @Test
    public void updateTShirt(){

        //populating the first T shirt without the id

        TShirt tShirt=new TShirt();

        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V neck");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(50);

        tShirtsDao.addTShirt(tShirt); // adding the first t shirt

        //populating the Updated T shirt without the id



        tShirt.setSize("M");
        tShirt.setColor("White");
        tShirt.setDescription("Crew neck");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(50);

        tShirtsDao.updateTShirt(tShirt);

        TShirt tShirt1= tShirtsDao.getTShirt(tShirt.gettShirtId()); // adding the updated t shirt into t shirt1
        //compare
        assertEquals(tShirt1,tShirt);

    }

    @Test
    public void getTShirtsByColor(){

        //populating the t shirt

        TShirt tShirt=new TShirt();

        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V neck");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(50);

        tShirt=tShirtsDao.addTShirt(tShirt); // adding the first t shirt

        //adding the same t shirt with same color
        tShirt=new TShirt();

        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V neck");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(50);

        tShirt=tShirtsDao.addTShirt(tShirt); // adding the t shirt with same color

        //passing the 2 t shirt into a list

        List<TShirt> byColor= tShirtsDao.getTShirtsByColor("Black");
        assertEquals(2,byColor.size());// same color has 2 t shirt

        byColor= tShirtsDao.getTShirtsByColor("Fake color"); // doesn't exist

        assertEquals(0,byColor.size());

    }

    @Test
    public void getTShirtBySize(){

        //populating the t shirt

        TShirt tShirt=new TShirt();

        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V neck");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(50);

        tShirt=tShirtsDao.addTShirt(tShirt); // adding the first t shirt

        //adding the same t shirt with same size
        tShirt=new TShirt();

        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("V neck");
        tShirt.setPrice(new BigDecimal("15.99"));
        tShirt.setQuantity(50);

        tShirt=tShirtsDao.addTShirt(tShirt); // adding the t shirt with same size

        //passing the 2 t shirt into a list

        List<TShirt> bySize= tShirtsDao.getTShirtBySize("M");
        assertEquals(2,bySize.size());// same color has 2 t shirt

        bySize= tShirtsDao.getTShirtBySize("Fake size"); // doesn't exist

        assertEquals(0,bySize.size());

    }

}
