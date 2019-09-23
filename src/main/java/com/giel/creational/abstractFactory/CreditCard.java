package com.giel.creational.abstractFactory;

public abstract class CreditCard {
    protected int cardNumberLength;
    protected int cscNumber;

    public int getCscNumber() {
        return cscNumber;
    }

    public void setCscNumber(int cscNumber) {
        this.cscNumber = cscNumber;
    }

    public int getCardNumberLength() {
        return cardNumberLength;
    }

    public void setCardNumberLength(int cardNumberLength) {
        this.cardNumberLength = cardNumberLength;
    }
}
