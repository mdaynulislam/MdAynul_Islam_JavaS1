package com.company;

public class RewardsCard {

    private String cardNumber;
    private float originalAmount;
    private float currentBalance;
    private boolean hasCard;

    public RewardsCard(String cardNumber, float originalAmount, float currentBalance, boolean hasCard)

                     {
                    this.cardNumber = cardNumber;
                    this.originalAmount = originalAmount;
                    this.currentBalance = currentBalance;
                    this.hasCard = hasCard;
                     }

            public String getCardNumber() {
                return cardNumber;
            }

            public void setCardNumber(String cardNumber) {
                this.cardNumber = cardNumber;
            }

            public float getOriginalAmount() {
                return originalAmount;
            }

            public void setOriginalAmount(float originalAmount) {
                this.originalAmount = originalAmount;
            }

            public float getCurrentBalance() {
                return currentBalance;
            }

            public void setCurrentBalance(float currentBalance) {
                this.currentBalance = currentBalance;
            }

            public boolean isHasCard() {
                return hasCard;
            }

            public void setHasCard(boolean hasCard) {
                this.hasCard = hasCard;
            }
}
