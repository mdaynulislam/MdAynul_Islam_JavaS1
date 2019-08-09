package com.company;

public class IceCreamFactory {

    private String name;
    private int quantityProduced;
    private int costOfProduction;
    private int costOfEmployee;
    private int productInStock;
    private boolean qualityControl;

    public IceCreamFactory(String name, int quantityProduced, int costOfProduction, int costOfEmployee,
                   int productInStock, boolean qualityControl)

                    {
                    this.name = name;
                    this.quantityProduced = quantityProduced;
                    this.costOfProduction = costOfProduction;
                    this.costOfEmployee = costOfEmployee;
                    this.productInStock = productInStock;
                    this.qualityControl = qualityControl;
                  }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getQuantityProduced() {
                return quantityProduced;
            }

            public void setQuantityProduced(int quantityProduced) {
                this.quantityProduced = quantityProduced;
            }

            public int getCostOfProduction() {
                return costOfProduction;
            }

            public void setCostOfProduction(int costOfProduction) {
                this.costOfProduction = costOfProduction;
            }

            public int getCostOfEmployee() {
                return costOfEmployee;
            }

            public void setCostOfEmployee(int costOfEmployee) {
                this.costOfEmployee = costOfEmployee;
            }

            public int getProductInStock() {
                return productInStock;
            }

            public void setProductInStock(int productInStock) {
                this.productInStock = productInStock;
            }

            public boolean isQualityControl() {
                return qualityControl;
            }

            public void setQualityControl(boolean qualityControl) {
                this.qualityControl = qualityControl;
            }
}
