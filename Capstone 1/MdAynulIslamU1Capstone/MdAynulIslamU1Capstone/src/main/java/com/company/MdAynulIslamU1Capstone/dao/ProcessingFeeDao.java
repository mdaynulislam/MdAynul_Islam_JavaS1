package com.company.MdAynulIslamU1Capstone.dao;

import com.company.MdAynulIslamU1Capstone.model.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {


    //CRUD


    ProcessingFee getProcessingFee(String productType);

    List<ProcessingFee> getAllProcessingFees();

    //so far I don't need it; if I do then will implement these

//    ProcessingFee addProcessingFee(ProcessingFee processingFee);
//
//    void updateProcessingFee(ProcessingFee processingFee);
//
//    void deleteProcessingFee(String productType);


}
