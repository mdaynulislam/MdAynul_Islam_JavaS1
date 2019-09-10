package com.company.MdAynulIslamU1Capstone.dao;

import com.company.MdAynulIslamU1Capstone.model.SalesTaxRate;

import java.util.List;

public interface SalesTaxRateDao {

    //CRUD



    SalesTaxRate getSalesTaxRate(String state);

    List<SalesTaxRate> getAllSalesTaxRates();


    //so far I don't need it; if I do then will implement these
//    SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate);
//
//    void updateSalesTaxRate(SalesTaxRate salesTaxRate);
//
//    void deleteSalesTaxRate(String state);


}
