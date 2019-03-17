package net.javaprogman.dbEntityManager;

import net.javaprogman.DBEntity.Client;
import net.javaprogman.DBEntity.Sex;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                 connection.commit();
                 return client;
             } else throw new SQLException();



        }catch (SQLException e){
            try {
                connection.rollback();
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
    public void createEntity(Client client) {
        String query = "insert into clients (name, passport, birthdate, sex) values (?,?,?,?)";
        PreparedStatement ps = getPreparedStatement(query);
        try {

            ps.setString(1, client.getName());
            ps.setString(2, client.getPassport());
            ps.setDate(3, new java.sql.Date(client.getBirthdate().getTime()));
            ps.setString(4, client.getSex().name());
            if (ps.executeUpdate() > 0) {
                connection.commit();
                System.out.println("New client add");
            } else {
                System.out.println("New client don't add");
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - Client.createEntity " + e);
        }finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        String query = "delete from clients where id=" + Integer.toString(id);
        PreparedStatement ps = getPreparedStatement(query);
        try {
            ps.executeUpdate();
            connection.commit();
            System.out.println("Client deleted");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - clientController.deleteEntity");
        }finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public Client stringToEntity(String input) {
        String[] splitted = input.split(" ");
        String name = "";
        String passport = "";
        Date birthdate = new Date();
        Sex sex = Sex.N_A;
        if (splitted.length == 4) {
            try {
                name = splitted[0];
                passport = splitted[1];
                birthdate = new SimpleDateFormat("yyyy-mm-dd").parse(splitted[2]);
                sex = Sex.valueOf(splitted[3]);

            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Error - Client.stringToEntity : don't parse. See input client data!!!");
            }
            return new Client(0, name, passport, birthdate, sex);
        } else {
            System.out.println("Incorrect number of parametrs entered ...");
            throw new IndexOutOfBoundsException();
        }
    }
}
