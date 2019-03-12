package net.javaprogman.clients;

import net.javaprogman.paymentInstrument.Accounts;
import net.javaprogman.paymentInstrument.Card;

import java.util.ArrayList;
import java.util.Date;

public class Client extends Person {

    private Integer cln_num;
    /*
    private String name;
    private String passport;
    private Date birthdate;
    private Sex sex;
    */
    private ArrayList<Accounts> accounts;
    private ArrayList<Card> card;





    Client(String name, Date birthdate, Sex sex, String passport, ArrayList<Card> card) {

        super(name, birthdate, sex, passport);
        this.card = card;
    }


    public ArrayList<Card> getCard() {
        return card;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {

                return  "Client : " + this.getName() + " , birthdate - " + this.getBirthdate()
                        + " , sex - " + this.getSex();
    }
}
