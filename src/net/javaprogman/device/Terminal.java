package net.javaprogman.device;

import net.javaprogman.DBEntity.Card;

public interface Terminal {

    //public boolean takePin(); //don't use

    public boolean verification(Card card);

    //public boolean payment();  //don't use

    public boolean p2p(Card cardFrom, Card cardTo);


}
