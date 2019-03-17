package net.javaprogman.device;

import net.javaprogman.DBEntity.Accounts;
import net.javaprogman.DBEntity.Card;
import net.javaprogman.dbEntityManager.AccountController;
import net.javaprogman.dbEntityManager.CardController;
import net.javaprogman.dbEntityManager.ClientController;
import net.javaprogman.dbEntityManager.EntityController;

import java.sql.SQLException;

public class Tusson implements Terminal {

    private final ClientController clientController;
    private final AccountController accountController;
    private final CardController cardController;


    public Tusson(ClientController clientController, AccountController accountController, CardController cardController) {
        this.clientController = clientController;
        this.accountController = accountController;
        this.cardController = cardController;
    }

    @Override
    public boolean verification(Card cardForVerify) {
        Card card = cardController.getCardByNumber(cardForVerify.getСardNumber());
        if (cardForVerify.getPin().equals(card.getPin())) {
            return true;
        } else return false;
    }


    @Override
    public boolean p2p(Card cardFrom, Card cardTo, Integer amount) {
        if (verification(cardFrom)) {
            if (balance(cardFrom) >= amount) {
                Accounts accountsFrom = accountController.getEntityById(cardFrom.getAcount_id());
                accountsFrom.setAmount(accountsFrom.getAmount() - amount);
                Accounts accountsTo = accountController.getEntityById(cardTo.getAcount_id());
                accountsTo.setAmount(accountsTo.getAmount() + amount);
                try {
                    accountController.updateEntityWithoutCommit(accountsFrom);
                    accountController.updateEntityWithoutCommit(accountsTo);
                    accountController.connection.commit();
                } catch (Exception e) {
                    try {
                        accountController.connection.rollback();
                    } catch (SQLException roolE) {
                        System.out.println("Transfer money is not passed. Rollback is bad.");
                    }
                    System.out.println("Transfer money is not passed.");
                }
                return true;
            } else {
                System.out.println("Insufficient funds");
                return false;
            }

        } else {
            System.out.println("Pin incorrect!");
            return false;
        }
    }

    @Override
    public boolean pinChange(Card card) {
        System.out.println("Pin change - temporarily not working ...");
        return false;
    }

    @Override
    public Integer balance(Card cardForBalance) {
        if (verification(cardForBalance)) {
            Accounts accountsFrom = accountController.getEntityById(cardForBalance.getAcount_id());
            return accountsFrom.getAmount();

        } else {
            System.out.println("Pin incorrect!");
            return 0;
        }
    }
}
