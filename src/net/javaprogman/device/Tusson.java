package net.javaprogman.device;

import net.javaprogman.paymentInstrument.Card;

public class Tusson implements Terminal {


    @Override
   public boolean verification(Card card) {
        return false;
    }


    @Override
    public boolean p2p(Card cardFrom, Card cardTo) {
        return false;
    }
}
