package com.company.U2M3Summative.dao;


import com.company.U2M3Summative.model.ProcessingFee;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {

    //prepare statement

    //get processing fee
    private static final String SELECT_PROCESSING_FEE_SQL=
            "select * from processing_fee where product_type = ?";

    //get All Processing fee

    private  static final String SELECT_ALL_PROCESSING_FEES_SQL=
            "select * from processing_fee";

    //injecting the jdbc to interact with the database
    private JdbcTemplate jdbcTemplate;

    //constructor for jdbc template

    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Mapping between the row and the object in the Table
    private ProcessingFee mapToRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException{

        ProcessingFee processingFee =new ProcessingFee();

        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));
        return processingFee;
    }

    @Override
    public ProcessingFee getProcessingFee(String productType) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_SQL,this::mapToRowToProcessingFee,productType);
        }catch (EmptyResultDataAccessException e){
            //if no match found then return null
            return null;
        }
    }

    @Override
    public List<ProcessingFee> getAllProcessingFees() {
        return jdbcTemplate.query(SELECT_ALL_PROCESSING_FEES_SQL,this::mapToRowToProcessingFee);
    }
}
