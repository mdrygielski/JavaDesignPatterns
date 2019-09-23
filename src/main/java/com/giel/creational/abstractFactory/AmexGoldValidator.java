package com.giel.creational.abstractFactory;

public class AmexGoldValidator implements Validator {

    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
