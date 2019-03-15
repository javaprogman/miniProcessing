package net.javaprogman.dbEntityManager;

import net.javaprogman.DBEntity.Client;
import net.javaprogman.DBEntity.Sex;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientController extends EntityController<Client, Integer> {

    //private final String oneClient "select * from clients where id=" + inputId;


    public ClientController(Connection connection) {
        super(connection);
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public void reportAll() {
        String query = "select * from clients";
        PreparedStatement ps = getPreparedStatement(query);
        try {
            ResultSet rs = ps.executeQuery();
            List<Client> lAllClient = new ArrayList<>();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String passport = rs.getString("passport");
                Date birthdate = rs.getDate("birthdate");
                Sex sex = Sex.valueOf(rs.getString("sex"));
                lAllClient.add(new Client(id, name, passport, birthdate, sex));
            }
         lAllClient.forEach(System.out::println);

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error ClientController.reportAll" + e);
        } finally {
            closePreparedStatement(ps);
        }

    }

    @Override
    public Client getEntityById(Integer id) {
        return null;
    }

    @Override
    public Client updateEntity(Client client){
        String query = String.format("update clients set name='%s', passport='%s' where id=%d",
                client.getName(), client.getPassport(), client.getId());
        PreparedStatement ps = getPreparedStatement(query);
        try{
             if (ps.executeUpdate(query)>0) {
                 return client;
             } else throw new SQLException();



        }catch (SQLException e){
            try {
                EntityController.connection.rollback();
            } catch (SQLException ee) {
                System.out.println("Rollback is bad - ClientController.updateEntity " + ee);
            }
            e.printStackTrace();
            System.out.println("Error - ClientController.updateEntity " + e);
        }
            finally
         {
            closePreparedStatement(ps);
        }
        return client;
    }

    @Override
    public boolean createEntity(Client client) {
        return false;
    }

    @Override
    public boolean deleteEntity(Integer id) {
        return false;
    }
}
