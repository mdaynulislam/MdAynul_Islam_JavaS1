package com.company.MdAynulIslamU1Capstone.daoTest;


import com.company.MdAynulIslamU1Capstone.dao.ProcessingFeeDao;
import com.company.MdAynulIslamU1Capstone.model.ProcessingFee;
import org.junit.Before;
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
public class ProcessingFeeDaoJdbcTemplateImplTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    // WE DON'T NEED TO DELETE PROCESSING FEE????????

    @Test
    public void getProcessingFee(){
        //populating the processing fee
        ProcessingFee processingFee =new ProcessingFee();

        processingFee.setProductType("T-Shirts");
        processingFee.setFee(new BigDecimal("1.98"));

        ProcessingFee processingFee1=processingFeeDao.getProcessingFee("T-Shirts");

        assertEquals(processingFee1,processingFee);
    }

    @Test
    public void getAllProcessingFees(){

        //populating the processing fee
        List<ProcessingFee> processingFeeList=processingFeeDao.getAllProcessingFees();

        assertEquals(processingFeeList.size(),3);
    }

}
