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
        /*InternetBank ib = new InternetBank(connection);
        ib.start();*/
        /*PreparedStatement statement = connection.prepareStatement(SELECT_CLIENT);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString(2));

        }*/

       /* String query = String.format("update clients set name='%s', passport='%s' where id=%d",
                "ASDF", "FJHKD", 1);
        System.out.println(query);*/

        ClientController cc = new ClientController(connection);
        //cc.reportAll();
        AccountController ac = new AccountController(connection);
        //ac.reportAll();
        CardController cac = new CardController(connection);
        //cac.reportAll();
        System.out.println(cac.getCardByNumber("0000001234"));
        Tusson tusson = new Tusson(cc, ac, cac);
        System.out.println(tusson.verification(new Card("0000001234", "9999", 1, 1 )));
        System.out.println(tusson.balance(new Card("0000001234", "9999", 1, 1 )));


     /*  Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");


       cc.updateEntity(new Client(1, "Vod Alexander", "MP67890", sdf.parse("1984-03-10"),Sex.MALE));
        cc.reportAll();*/

        //statement.close();

        //cac.updateEntity(new Card("0000001234", "9999", 1 ));

        /*cac.createEntity(cac.stringToEntity("Masha MP3456 1991-04-27 FEMALE"));
        cac.reportAll();*/

        /*cc.createEntity(cc.stringToEntity("Masha MP3456 1991-04-27 FEMALE"));
        cc.reportAll();*/
        /*ac.createEntity(ac.stringToEntity("7898797 333 1"));
        ac.reportAll();*/
        /*cac.createEntity(cac.stringToEntity("0000000000666666 3434 1 1"));
        cac.reportAll();*/
        /*cac.deleteEntity("0000000000666666");
        cac.reportAll();*/

       /*cc.reportAll();
        connection.close();*/

       /* InternetBank ib = new InternetBank();
        ib.start();*/

       /*double x1 = 3;
       double y1 = 2;
       double x2 = 9;
       double y2 = 4;
       double deltax = (y2-y1)/(x2-x1);
       double deltay = (y2-y1)/(x2-x1)*deltax;
       int j = (int)((x2-x1)/deltax);
       for (int i = 0; i <= j*10; i++){
           x1 += deltax/10;
           y1 += deltay/10;
           System.out.println((int)x1+" " +(int)y1);

       }*/
    }
}
