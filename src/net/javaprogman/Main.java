package net.javaprogman;

import java.sql.*;

public class Main {


    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASS = "rootroot";

    private static final String SELECT_CLIENT = "select * from clients";

    public static void main(String[] args)throws ClassNotFoundException, SQLException {

        System.out.println("Registering JDBC driver....");
        Class.forName(JDBC_DRIVER);
        System.out.println("Creating connection ....");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement(SELECT_CLIENT);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString(2));

        }

        statement.close();
        connection.close();
    }
}
