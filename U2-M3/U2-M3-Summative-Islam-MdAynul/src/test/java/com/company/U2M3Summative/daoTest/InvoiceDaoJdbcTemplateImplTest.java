package com.company.U2M3Summative.daoTest;

import com.company.U2M3Summative.dao.InvoiceDao;
import com.company.U2M3Summative.model.Invoice;
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
public class InvoiceDaoJdbcTemplateImplTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp()throws Exception{

        //deleting the invoice in the Database
        List<Invoice> invoiceList =invoiceDao.getAllInvoices();
        for(Invoice iv: invoiceList){
            invoiceDao.deleteInvoice(iv.getInvoiceId());
        }
    }
    @Test
    public void addGetDeleteInvoice(){

        //without the invoice id; it's a PK
        Invoice invoice = new Invoice();

        invoice.setName("John");
        invoice.setStreet("169th");
        invoice.setCity("Jamaica");
        invoice.setState("NY");
        invoice.setZipCode("11423");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("60.33"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("70.33")); // (unit price* quantity)* Tax)+ processing fee = total

        invoice=invoiceDao.addInvoice(invoice); // adding the invoice in the dao

        Invoice invoice1= invoiceDao.getInvoice(invoice.getInvoiceId()); //passing the same invoice into invoice1

        //compare
        assertEquals(invoice1,invoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId()); //deleting the invoice
        invoice1=invoiceDao.getInvoice(invoice.getInvoiceId()); // passing the deleted invoice into invoice1
        assertNull(invoice1);
    }

    @Test
    public void getAllInvoices(){
        //populating the first invoice

        Invoice invoice = new Invoice();

        invoice.setName("John");
        invoice.setStreet("169th");
        invoice.setCity("Jamaica");
        invoice.setState("NY");
        invoice.setZipCode("11423");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("60.33"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("70.33")); // (unit price* quantity)* Tax)+ processing fee = total

        invoice=invoiceDao.addInvoice(invoice);

        //populating the 2nd invoice

         invoice = new Invoice();

        invoice.setName("John2");
        invoice.setStreet("197th");
        invoice.setCity("Hollis");
        invoice.setState("NY");
        invoice.setZipCode("11423");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("60.33"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("70.33")); // (unit price* quantity)* Tax)+ processing fee = total

        invoiceDao.addInvoice(invoice); // adding the 2nd invoice

        //passing all the invoices into a list

        List<Invoice> invoiceList= invoiceDao.getAllInvoices();
        //comparing the list which should have 2 invoices
        assertEquals(2,invoiceList.size());

    }

    @Test

    public void updateInvoice(){

        //populating the first invoice

        Invoice invoice = new Invoice();

        invoice.setName("John");
        invoice.setStreet("169th");
        invoice.setCity("Jamaica");
        invoice.setState("NY");
        invoice.setZipCode("11423");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("60.33"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("70.33")); // (unit price* quantity)* Tax)+ processing fee = total

        invoice=invoiceDao.addInvoice(invoice); // adding the first invoice

        //populating the same invoice with updated data

        invoice.setName("John Updated");
        invoice.setStreet("169th Updated");
        invoice.setCity("Jamaica");
        invoice.setState("NY");
        invoice.setZipCode("11423");
        invoice.setItemType("Game");
        invoice.setItemId(1);
        invoice.setUnitPrice(new BigDecimal("12.99"));
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal("60.33"));
        invoice.setTax(new BigDecimal("0.06"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("70.33")); // (unit price* quantity)* Tax)+ processing fee = total

        invoiceDao.updateInvoice(invoice);

        Invoice invoice1=invoiceDao.getInvoice(invoice.getInvoiceId()); //passing the updated invoice into invoice1

        assertEquals(invoice1,invoice);

    }


}
