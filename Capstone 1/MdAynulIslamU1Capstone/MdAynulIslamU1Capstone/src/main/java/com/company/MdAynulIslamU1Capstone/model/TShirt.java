package com.company.MdAynulIslamU1Capstone.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {

    //properties of TShirt
    private int tShirtId; //PK
    @NotNull
    @Max(value = 20, message = "T shirt size cannot be more than 20")
    private String size;
    @NotNull
    @Max(value = 20, message = "Out of Limit for Color entry")
    private String color;
    @NotNull
    @Max(value = 255, message = "Description has a limit")
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    @Max(value = 11, message = "T shirt quantity cannot be more than 11")
    private int quantity;

    //getters and setters


    public int gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Equal and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tShirt = (TShirt) o;
        return tShirtId == tShirt.tShirtId &&
                quantity == tShirt.quantity &&
                size.equals(tShirt.size) &&
                color.equals(tShirt.color) &&
                description.equals(tShirt.description) &&
                price.equals(tShirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, price, quantity);
    }
}
