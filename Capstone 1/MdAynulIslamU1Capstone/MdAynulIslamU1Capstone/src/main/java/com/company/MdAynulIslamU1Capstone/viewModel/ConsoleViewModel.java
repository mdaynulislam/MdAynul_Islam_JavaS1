package com.company.MdAynulIslamU1Capstone.viewModel;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {

    //properties for Console

    private int consoleId; // PK
    @Size(max = 50,message = "Too big for a model")
    private String model;
    @Size(max = 50, message = "Too big for a manufacturer")
    private String manufacturer;
    @Size(max = 30,message = "too big for a memory amount")
    private String memoryAmount;
    @Size(max = 20)
    private String processor;

    private BigDecimal price;
    @NotNull(message = "Console Quantity cannot be null")
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

    //equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return consoleId == that.consoleId &&
                quantity == that.quantity &&
                model.equals(that.model) &&
                manufacturer.equals(that.manufacturer) &&
                memoryAmount.equals(that.memoryAmount) &&
                processor.equals(that.processor) &&
                price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
