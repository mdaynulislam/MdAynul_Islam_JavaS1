package com.company.MdAynulIslamU1Capstone.controller;

import com.company.MdAynulIslamU1Capstone.exception.NotFoundException;
import com.company.MdAynulIslamU1Capstone.service.GameInventoryService;
import com.company.MdAynulIslamU1Capstone.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class InvoiceViewController {

    @Autowired
    GameInventoryService service;


    /******************************InvoiceViewModel controller***********************************/

    //add invoice
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel){
        return service.saveInvoice(invoiceViewModel);
    }

    //find invoice
    @RequestMapping(value = "/invoice/{id}",method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable (name = "id") int id){
        InvoiceViewModel invoiceViewModel =service.findInvoice(id);
        if(invoiceViewModel == null)
            throw new NoSuchElementException("Invoice could not be retrieve for this id "+id);
        return invoiceViewModel;
    }

    //find All Invoices
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices(){
        return service.findAllInvoices();
    }

    //update Invoice
    @RequestMapping(value = "/invoice/{id}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateInvoice(@PathVariable (name = "id") int invoiceId, @Valid @RequestBody InvoiceViewModel invoiceViewModel ){
        if(invoiceViewModel.getInvoiceId()== 0)
            invoiceViewModel.setInvoiceId(invoiceId);
        if(invoiceId != invoiceViewModel.getInvoiceId()){
            throw new IllegalArgumentException("Invoice Id on the path must match in the Invoice object");
        }
        service.updateInvoice(invoiceViewModel);
    }

    //delete invoice

    @RequestMapping(value = "/invoice/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteInvoice(@PathVariable(name = "id") int id){
        InvoiceViewModel invoiceViewModel =service.findInvoice(id);

        if(invoiceViewModel == null){
            throw new NotFoundException("No invoice available with this Id. ");
        }else {
            service.removeInvoice(id);
        }
    }



}
