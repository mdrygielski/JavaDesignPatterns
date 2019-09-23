package com.giel.creational.abstractFactory;

public class VisaValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return false;
    }
}
