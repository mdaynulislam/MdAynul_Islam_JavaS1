package com.company.U2M3Summative.dao;

import com.company.U2M3Summative.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    //CRUD

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int invoiceId);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int invoiceId);


}
