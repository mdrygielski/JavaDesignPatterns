package com.giel.creational.abstractFactory;

public class VisaFactory extends CreditCardFactory {

    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType){
            case GOLD:
                return new VisaGoldCard();

            case PLATINUM:
                return new VisaBlackCreditCard();

        }
        return null;
    }

    public Validator getValidator(CardType cardType) {
        return new VisaValidator();
    }
}
