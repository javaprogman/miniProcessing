package net.javaprogman.dbservices;

import net.javaprogman.dbEntityManager.AccountController;
import net.javaprogman.dbEntityManager.CardController;
import net.javaprogman.dbEntityManager.ClientController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class InternetBank {

    private final ClientController clientController;
    private final AccountController accountController;
    private final CardController cardController;

    public InternetBank(Connection connection) {
        this.clientController = new ClientController(connection);
        this.accountController = new AccountController(connection);
        this.cardController = new CardController(connection);
    }

    public void start() throws SQLException, IndexOutOfBoundsException {

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            String input = "";

            while (!input.equals("0")) {
                printWelcom();
                input = bf.readLine();

                switch(input){
                    case "1" :
                        System.out.println("\n Enter  name, passport, birthday and sex");
                        clientController.createEntity(clientController.stringToEntity(bf.readLine()));
                        break ;
                    case "2" :
                        System.out.println("\n Enter account_number, amount, client_id");
                        accountController.createEntity(accountController.stringToEntity(bf.readLine()));
                        break;
                    case "3" :
                        System.out.println("\n Enter cardNumber, pin, account_id, client_id");
                        cardController.createEntity(cardController.stringToEntity(bf.readLine()));
                        break;
                    case "4" :
                        System.out.println("\n Client report - beta version :");
                        clientController.reportAll();
                        break;
                    case "5" :
                        System.out.println("\n Account report - beta version :");
                        accountController.reportAll();
                        break;
                    case "6" :
                        System.out.println("\n Card report - beta version :");
                        cardController.reportAll();
                        break;
                    case "7" :
                        clientController.reportAll();
                        System.out.println("\n What client delete (enter client_id) :");
                        clientController.deleteEntity(Integer.parseInt(bf.readLine()));
                        break;
                    case "8" :
                        accountController.reportAll();
                        System.out.println("\n What account delete (enter account_id) :");
                        accountController.deleteEntity(Integer.parseInt(bf.readLine()));
                        break;
                    case "9" :
                        cardController.reportAll();
                        System.out.println("\n What card delete (enter cardNumber) :");
                        cardController.deleteEntity(bf.readLine());
                        break;


                    case "0" : // -- in working
                        System.out.println("\n See you later!");
                        break;


                }
            }
        } catch (IOException | IndexOutOfBoundsException e) {
           e.printStackTrace();
        }


    }

    public void printWelcom () {

        System.out.println("\nWe are glad to welcome you !");
        System.out.println("\tHow we can help you?\n");
        System.out.println("---------------------------------");
        System.out.println("\t1 : add new Client");
        System.out.println("\t2 : add new Account");
        System.out.println("\t3 : add new Card");
        System.out.println("\t4 : Client Report");
        System.out.println("\t5 : Account Report");
        System.out.println("\t6 : Card Report");
        System.out.println("\t7 : Client delete");
        System.out.println("\t8 : Account delete");
        System.out.println("\t9 : Card delete");
        System.out.println("\tp2p : Transfer Money - in working");
        System.out.println("\tpinCh : Pin change - in working");
        System.out.println("\t0 : Exit");
        System.out.println("Choice : ");
    }
}
