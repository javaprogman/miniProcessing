package net.javaprogman.dbservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class InternetBank {


    public void start() throws SQLException {

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {

            String input = "";

            while (!input.equals("0")) {
                printWelcom();
                input = bf.readLine();

                switch(input){
                    case "1" :
                        System.out.println("\n Enter  name, passport, birthday and sex");
                }
            }
        } catch (IOException e) {
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
        System.out.println("\tp2p : Transfer Money");
        System.out.println("\t0 : Exit");
        System.out.println("Choice : ");
    }
}
