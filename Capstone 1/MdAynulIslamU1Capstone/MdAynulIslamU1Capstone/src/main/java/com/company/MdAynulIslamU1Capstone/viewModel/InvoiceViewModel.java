package com.company.MdAynulIslamU1Capstone.viewModel;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class InvoiceViewModel {

    //properties of Invoice

    private int invoiceId; //PK
    @NotEmpty(message = "Name field cannot be empty")
    private String name;
    @NotEmpty(message = "Street field cannot be empty")
    private String street;
    @NotEmpty(message = "City field cannot be empty")
    private String city;
    @NotEmpty(message = "State field cannot be empty")
    @Size(max = 2,message = "state must be two character long")
    private String state;
    @NotEmpty(message = "zipCode field cannot be empty")
    @Size(max = 5, message = "zipCode cannot be more than 5 character long")
    private String zipCode;
    @NotEmpty(message = "Item Type field cannot be empty")
    private String itemType;
    @NotNull(message = "Item id cannot be null")
    private int itemId;
    private BigDecimal unitPrice;
    @NotNull(message = "Quantity cannot be Null")
    private int quantity;
   //No validation because the user won't insert this value in jason

    private BigDecimal subtotal;
    //No validation because the user won't insert this value in jason
    private BigDecimal tax;
    //No validation because the user won't insert this value in jason
    private BigDecimal processingFee;
    //No validation because the user won't insert this value in jason
    private BigDecimal total;


    //getters and setters


    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal.setScale(2, RoundingMode.CEILING); // rounding the scale up to 2
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total.setScale(2, RoundingMode.CEILING);  // rounding the scale up to 2

    }

    //Equal and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return invoiceId == that.invoiceId &&
                itemId == that.itemId &&
                quantity == that.quantity &&
                name.equals(that.name) &&
                street.equals(that.street) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                zipCode.equals(that.zipCode) &&
                itemType.equals(that.itemType) &&
                unitPrice.equals(that.unitPrice) &&
                subtotal.equals(that.subtotal) &&
                tax.equals(that.tax) &&
                processingFee.equals(that.processingFee) &&
                total.equals(that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipCode, itemType, itemId, unitPrice,
                quantity, subtotal, tax, processingFee, total);
    }
}
