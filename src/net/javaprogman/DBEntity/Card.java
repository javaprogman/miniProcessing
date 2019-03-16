package net.javaprogman.DBEntity;

public class Card {

    private String cardNumber;
    private String pin;
    private Integer account_id;
    private Integer client_id;

    public Card(String сardNumber, String pin, Integer acount_id, Integer client_id) {
        this.cardNumber = сardNumber;
        this.pin = pin;
        this.account_id = acount_id;
        this.client_id = client_id;

    }

    public String getСardNumber() {
        return cardNumber;
    }

    public void setСardNumber(String сardNumber) {
        this.cardNumber = сardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Integer getAcount_id() {
        return account_id;
    }

    public void setAcount_id(Integer acount_id) {
        this.account_id = acount_id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "сardNumber='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                ", acount_id=" + account_id +
                '}';
    }
}
