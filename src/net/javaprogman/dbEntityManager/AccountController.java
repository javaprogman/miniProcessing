package net.javaprogman.dbEntityManager;

import net.javaprogman.DBEntity.Accounts;
import net.javaprogman.DBEntity.Client;
import net.javaprogman.DBEntity.Sex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountController extends EntityController<Accounts, Integer> {


    public AccountController(Connection connection) {
        super(connection);
    }

    @Override
    public List<Accounts> getAll() {
        return null;
    }

    @Override
    public void reportAll() {
        String query = "select * from accounts";
        PreparedStatement ps = getPreparedStatement(query);
        List<Accounts> lAllAccounts = new ArrayList<>();
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String account_number = rs.getString("account_number");
                Integer amount = rs.getInt("amount");
                Integer client_id = rs.getInt("client_id");

                lAllAccounts.add( new Accounts(id, account_number, amount, client_id));
            }
            lAllAccounts.forEach(System.out::println);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error - AccountController.reportAll " + e);
        } finally {
            closePreparedStatement(ps);
        }

    }

    @Override
    public Accounts getEntityById(Integer idIn) {
        String query = "select * from accounts where id=" + idIn;
        PreparedStatement ps = getPreparedStatement(query);
        Integer id = 0;
        String account_number = "";
        Integer amount = 0;
        Integer client_id = 0;
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                account_number = rs.getString("account_number");
                amount = rs.getInt("amount");
                client_id = rs.getInt("client_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - CardController - getCardByNumber");
        }
        return new Accounts(id, account_number, amount, client_id);
    }

    @Override
    public Accounts updateEntity(Accounts account) {
        String query = String.format("update accounts set amount='%d' where account_number='%s'",
                account.getAmount(),account.getAccount_number());
        PreparedStatement ps = getPreparedStatement(query);
        try {
            if(ps.executeUpdate() > 0){
                connection.commit();
                return account;
            }else {
                throw new SQLException();
            }
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ee) {
                System.out.println("Rollback is bad - accountsController.updateEntity " + ee);
            }
            e.printStackTrace();
            System.out.println("Error - Accounts controller.updateEntity " + e );
        } finally {
            closePreparedStatement(ps);
        }

        return account;
    }

    @Override
    public void createEntity(Accounts accounts) {
        String query = "insert into accounts (account_number, amount, client_id) values (?,?,?)";
        PreparedStatement ps = getPreparedStatement(query);
        try {

            ps.setString(1, accounts.getAccount_number());
            ps.setInt(2, accounts.getAmount());
            ps.setInt(3, accounts.getClient_id());
            if (ps.executeUpdate() > 0) {
                connection.commit();
                System.out.println("New account add");
            } else {
                System.out.println("New account don't add");
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - Account.createEntity " + e);
        }finally {
            closePreparedStatement(ps);
        }

    }

    @Override
    public void deleteEntity(Integer id) {
        String query = "delete from accounts where id=" + Integer.toString(id);
        PreparedStatement ps = getPreparedStatement(query);
        try {
            ps.executeUpdate();
            connection.commit();
            System.out.println("Account deleted");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - accountController.deleteEntity");
        }finally {
            closePreparedStatement(ps);
        }
            }

    @Override
    public Accounts stringToEntity(String input) {
        String[] splitted = input.split(" ");
        if (splitted.length == 3) {
            String account_number = splitted[0];
            Integer amount = Integer.parseInt(splitted[1]);
            Integer client_id = Integer.parseInt(splitted[2]);
            return new Accounts(0, account_number, amount, client_id);
        }
        else {
            System.out.println("Incorrect number of parametrs entered ...");
            throw new IndexOutOfBoundsException();
        }
    }
}
