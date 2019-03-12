package net.javaprogman.paymentInstrument;

public class Card extends PaymentInstrument {

    private String сardNumber;
    private String pin;
    private Integer acc_num;

    public Card(String сardNumber, String pin, Integer acc_num) {
        this.сardNumber = сardNumber;
        this.pin = pin;
        this.acc_num = acc_num;
    }

    public String getСardNumber() {
        return сardNumber;
    }

    public String getPin() {
        return pin;
    }

    public Integer getAcc_num() {
        return acc_num;
    }
}
