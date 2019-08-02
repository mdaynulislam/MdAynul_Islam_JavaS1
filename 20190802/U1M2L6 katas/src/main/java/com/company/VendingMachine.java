package com.company;

public class VendingMachine {

    private String chips;
    private String energyBar;
    private String drinks;
    private  Store soda;
    private  Store cracker;

    public String getChips() {
        return chips;
    }

    public void setChips(String chips) {
        this.chips = chips;
    }

    public String getEnergyBar() {
        return energyBar;
    }

    public void setEnergyBar(String energyBar) {
        this.energyBar = energyBar;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public Store getSoda() {
        return soda;
    }

    public void setSoda(Store soda) {
        this.soda = soda;
    }

    public Store getCracker() {
        return cracker;
    }

    public void setCracker(Store cracker) {
        this.cracker = cracker;
    }

    public void suppliesPerWeek(int sp){
        return;

    }
}
