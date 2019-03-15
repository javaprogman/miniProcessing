package net.javaprogman.DBEntity;

import net.javaprogman.dbservices.InternetBank;

public class Accounts {

    private Integer id;
    private String account_number;
    private Integer amount;
    private Integer client_id;

    public Accounts(Integer id, String account_number, Integer amount, Integer client_id) {
        this.id = id;
        this.account_number = account_number;
        this.amount = amount;
        this.client_id = client_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", account_number='" + account_number + '\'' +
                ", amount=" + amount +
                ", client_id=" + client_id +
                '}';
    }
}
