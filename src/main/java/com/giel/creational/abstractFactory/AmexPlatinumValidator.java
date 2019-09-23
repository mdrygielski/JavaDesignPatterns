package com.giel.creational.abstractFactory;

public class AmexPlatinumValidator implements Validator {

    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
