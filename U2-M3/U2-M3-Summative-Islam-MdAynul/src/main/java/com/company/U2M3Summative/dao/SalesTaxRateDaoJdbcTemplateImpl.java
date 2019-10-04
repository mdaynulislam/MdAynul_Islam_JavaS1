package com.company.U2M3Summative.dao;

import com.company.U2M3Summative.model.SalesTaxRate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao {

    //prepare statement

    //get Sales tax rate
    private static final String SELECT_SALES_TAX_RATE_SQL=
            "select * from sales_tax_rate where state = ?";

    //get all sales tax rate
    private static final String SELECT_ALL_SALES_TAX_RATES_SQL =
            "select * from sales_tax_rate";

    //injecting the jdbc to interact to the database
    private JdbcTemplate jdbcTemplate;

    //constructor for jdbc
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Mapping between row and object to the Database table
    private SalesTaxRate mapToRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException{

        SalesTaxRate salesTaxRate=new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));
        return salesTaxRate;
    }

    @Override
    public SalesTaxRate getSalesTaxRate(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_SQL,this::mapToRowToSalesTaxRate,state);
        }catch (EmptyResultDataAccessException e){
            //if there is no match will return null
            return null;
        }
    }

    @Override
    public List<SalesTaxRate> getAllSalesTaxRates() {
        return jdbcTemplate.query(SELECT_ALL_SALES_TAX_RATES_SQL,this::mapToRowToSalesTaxRate);
    }
}
