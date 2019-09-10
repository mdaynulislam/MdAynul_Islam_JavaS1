package com.company.MdAynulIslamU1Capstone.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class Console {
    //properties for Console

    private int consoleId; // PK
    @NotNull
    @Max(value = 50,message = "Model is too long")
    private String model;
    @NotNull
    @Max(value = 50,message = "Too long for manufacturer")
    private String manufacturer;
    @Max(20)
    private String memoryAmount;
    @Max(20)
    private String processor;
    @NotNull
    private BigDecimal price;
    @NotNull
    @Max(value = 11, message = "Quantity cannot exceed 11")
    private int quantity;

    //getters and setters


    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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

    //Equal and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return consoleId == console.consoleId &&
                quantity == console.quantity &&
                model.equals(console.model) &&
                manufacturer.equals(console.manufacturer) &&
                memoryAmount.equals(console.memoryAmount) &&
                processor.equals(console.processor) &&
                price.equals(console.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
