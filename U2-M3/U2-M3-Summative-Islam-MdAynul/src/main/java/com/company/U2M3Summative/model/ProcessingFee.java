package com.company.U2M3Summative.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {

    //properties of Processing fee
    @NotNull
    @Max(value = 20, message = "Processing type is limited by 20")
    private String productType;
    private BigDecimal fee;

    //getters and setters


    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    //Equal and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return productType.equals(that.productType) &&
                fee.equals(that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }
}
