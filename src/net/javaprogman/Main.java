package net.javaprogman;

import net.javaprogman.DBEntity.Card;
import net.javaprogman.DBEntity.Client;
import net.javaprogman.DBEntity.Sex;
import net.javaprogman.dbEntityManager.AccountController;
import net.javaprogman.dbEntityManager.CardController;
import net.javaprogman.dbEntityManager.ClientController;
import net.javaprogman.dbservices.InternetBank;
import net.javaprogman.device.Tusson;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {


    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "rootroot";

    private static final String SELECT_CLIENT = "select * from clients";


    public static void main(String[] args)throws ClassNotFoundException, SQLException, ParseException {


        System.out.println("Registering JDBC driver....");
        Class.forName(JDBC_DRIVER);
        System.out.println("Creating connection ....");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        connection.setAutoCommit(false);

        // Проверка рабоы с БД
        /*InternetBank ib = new InternetBank(connection);
        ib.start();*/

        // Проверка функциональности класса Tusson
       /* ClientController cc = new ClientController(connection);
        AccountController ac = new AccountController(connection);
        CardController cac = new CardController(connection);
        System.out.println(cac.getCardByNumber("0000001234"));
        Tusson tusson = new Tusson(cc, ac, cac);
        System.out.println(tusson.verification(new Card("0000001234", "9991", 1, 1 )));
        System.out.println(tusson.balance(new Card("0000001234", "9999", 1, 1 )));
        System.out.println(tusson.balance(new Card("0000019876", "1234", 2, 2 )));
        tusson.p2p(new Card("0000001234", "9999", 1, 1 ),
                new Card("0000019876", "1234", 2, 2 ),
                25);
        System.out.println(tusson.balance(new Card("0000001234", "9999", 1, 1 )));
        System.out.println(tusson.balance(new Card("0000019876", "1234", 2, 2 )));*/



    }
}
