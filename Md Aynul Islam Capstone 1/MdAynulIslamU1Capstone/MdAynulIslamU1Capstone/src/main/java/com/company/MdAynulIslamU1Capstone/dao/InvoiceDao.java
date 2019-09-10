package com.company.MdAynulIslamU1Capstone.dao;

import com.company.MdAynulIslamU1Capstone.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    //CRUD

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int invoiceId);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int invoiceId);


}
