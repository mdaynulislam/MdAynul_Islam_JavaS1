package com.company.MdAynulIslamU1Capstone.daoTest;


import com.company.MdAynulIslamU1Capstone.dao.SalesTaxRateDao;
import com.company.MdAynulIslamU1Capstone.model.SalesTaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoJdbcTemplateTest {

    @Autowired
    SalesTaxRateDao salesTaxRateDao;


    @Test
    public void getSalesTaxRate(){

        SalesTaxRate salesTaxRate=new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal("0.06"));

        SalesTaxRate salesTaxRate1=salesTaxRateDao.getSalesTaxRate("NY");
        assertEquals(salesTaxRate1,salesTaxRate);

    }

    @Test
    public void getAllSalesTaxRate(){

        List<SalesTaxRate> salesTaxRateList=salesTaxRateDao.getAllSalesTaxRates();
        assertEquals(salesTaxRateList.size(),50);

    }


}
