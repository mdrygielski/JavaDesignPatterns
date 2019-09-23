package com.giel.creational.abstractFactory;


public class AmexFactory extends CreditCardFactory {

    public CreditCard getCreditCard(CardType cardType) {

        switch(cardType) {
            case GOLD:
                return new AmexGoldCreditCard();

            case PLATINUM:
                return new AmexPlatinumCreditCard();
            default:
                break;
        }
        return null;
    }

    public Validator getValidator(CardType cardType) {

        switch(cardType) {
            case GOLD:
                return new AmexGoldValidator();

            case PLATINUM:
                return new AmexPlatinumValidator();
        }

        return null;
    }
}
