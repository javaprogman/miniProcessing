package net.javaprogman.paymentInstrument;

import java.util.HashMap;

public class Accounts {

    private String accounts;
    private Double amount;
    private Integer cln_num;
    private Integer acc_num;

    public Accounts(String accounts, Double amount, Integer cln_num, Integer acc_num) {
        this.accounts = accounts;
        this.amount = amount;
        this.cln_num = cln_num;
        this.acc_num = acc_num;
    }

    public String getAccounts() {
        return accounts;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getCln_num() {
        return cln_num;
    }

    public Integer getAcc_num() {
        return acc_num;
    }
}
