package com.company.MdAynulIslamU1Capstone.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Invoice {
    //properties of Invoice

    private int invoiceId; //PK
    @NotNull
    @Max(value = 80, message = "Name in invoice exceeding the limit")
    private String name;
    @NotNull
    @Max(value = 30, message = "Too big for a street")
    private String street;
    @NotNull
    @Max(value = 30, message = "City has a limited Character Size")
    private String city;
    @Max(value = 30, message = "Too big for a state")
    private String state;
    @Max(value = 5, message = "Zip code is limited by 5 number")
    @NotNull
    private String zipCode;
    @NotNull
    @Max(value = 20, message = "Item type exceeding limit")
    private String itemType;
    @Max(value = 11, message = "Item Id is limited by 11")
    @NotNull
    private int itemId;
    @NotNull
    private BigDecimal unitPrice;
    @NotNull
    @Max(value = 11, message = "Quantity is limited by 11")
    private int quantity;

    private BigDecimal subtotal;

    private BigDecimal tax;

    private BigDecimal processingFee;

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
        this.subtotal = subtotal.setScale(2, RoundingMode.CEILING);
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
        this.total = total.setScale(2, RoundingMode.CEILING);
    }

    //Equal and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId &&
                itemId == invoice.itemId &&
                quantity == invoice.quantity &&
                name.equals(invoice.name) &&
                street.equals(invoice.street) &&
                city.equals(invoice.city) &&
                state.equals(invoice.state) &&
                zipCode.equals(invoice.zipCode) &&
                itemType.equals(invoice.itemType) &&
                unitPrice.equals(invoice.unitPrice) &&
                subtotal.equals(invoice.subtotal) &&
                tax.equals(invoice.tax) &&
                processingFee.equals(invoice.processingFee) &&
                total.equals(invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipCode, itemType, itemId, unitPrice, quantity, subtotal, tax, processingFee, total);
    }
}
