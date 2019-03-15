package net.javaprogman.dbEntityManager;

import net.javaprogman.DBEntity.Accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public Accounts getEntityById(Integer id) {
        return null;
    }

    @Override
    public Accounts updateEntity(Accounts accounts) {
        return null;
    }

    @Override
    public boolean createEntity(Accounts accounts) {
        return false;
    }

    @Override
    public boolean deleteEntity(Integer id) {
        return false;
    }
}
