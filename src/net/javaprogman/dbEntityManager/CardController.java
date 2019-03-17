package net.javaprogman.dbEntityManager;

import net.javaprogman.DBEntity.Accounts;
import net.javaprogman.DBEntity.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardController extends EntityController<Card, Integer> {

    public CardController(Connection connection) {
        super(connection);
    }

    @Override
    public List<Card> getAll() {
        return null;
    }

    @Override
    public void reportAll() {
        String query = "select * from cards";
        PreparedStatement ps = getPreparedStatement(query);
        try{
            ResultSet rs = ps.executeQuery();
            List<Card> lc = new ArrayList<>();
            while (rs.next()){
                String cardNumber = rs.getString("cardNumber");
                String pin = rs.getString("pin");
                Integer account_id = rs.getInt("account_id");
                Integer client_id = rs.getInt("client_id");
                lc.add(new Card(cardNumber, pin, account_id, client_id));

            }
            lc.forEach(System.out::println);

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - CardController.reportAll " + e);
        } finally {
            closePreparedStatement(ps);
        }

    }

    @Override
    public Card getEntityById(Integer id) { return null; }


    public Card getCardByNumber(String cardNumberIn) {
        String query = "select * from cards where cardNumber=" + cardNumberIn;
        PreparedStatement ps = getPreparedStatement(query);
        String cardNumber = "";
        String pin = "";
        Integer account_id = 0;
        Integer client_id = 0;
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cardNumber = rs.getString("cardNumber");
                pin = rs.getString("pin");
                account_id = rs.getInt("account_id");
                client_id = rs.getInt("client_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - CardController - getCardByNumber");
        }
        return new Card(cardNumber, pin, account_id, client_id);
    }

    @Override
    public Card updateEntity(Card card) {
        String query = String.format("update cards set pin='%s' where cardNumber=%s",
                card.getPin(), card.getСardNumber());
        PreparedStatement ps = getPreparedStatement(query);
        try {

            if (ps.executeUpdate() > 0) {
                connection.commit();
                return card;
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            try {
                EntityController.connection.rollback();
            } catch (SQLException ee) {
                System.out.println("Rollback is bad - cardController.updateEntity " + ee);
            }
            e.printStackTrace();
            System.out.println("Error - CardClntroller.updateEntity " + e);
        } finally {
            closePreparedStatement(ps);
        }
       return card;
    }

    @Override
    public void createEntity(Card card) {
        String query = "insert into cards (cardNumber, pin, account_id, client_id) values (?,?,?,?)";
        PreparedStatement ps = getPreparedStatement(query);
        try {
            ps.setString(1, card.getСardNumber());
            ps.setString(2, card.getPin());
            ps.setInt(3, card.getAcount_id());
            ps.setInt(4, card.getClient_id());
            if (ps.executeUpdate() > 0) {
                connection.commit();
                System.out.println("New card add");
            } else {
                System.out.println("New card don't add");
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - card.createEntity " + e);
        } finally {
            closePreparedStatement(ps);
        }
    }

    @Override
    public void deleteEntity(Integer id) {
        System.out.println("This method is not implemented");
    }

    public void deleteEntity(String cardNumber) {
        String query = "delete from cards where cardNumber=" + cardNumber;
        PreparedStatement ps = getPreparedStatement(query);
        try {
            ps.executeUpdate();
            connection.commit();
            System.out.println("Card deleted");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error - cardController.deleteEntity");
        }finally {
            closePreparedStatement(ps);
        }
    }


    @Override
    public Card stringToEntity(String input) {
        String[] splitted = input.split(" ");
        if (splitted.length == 4) {
            String cardNumber = splitted[0];
            String pin = splitted[1];
            Integer account_id = Integer.parseInt(splitted[2]);
            Integer client_id = Integer.parseInt(splitted[3]);
            return new Card(cardNumber, pin, account_id, client_id);
        }
        else {
            System.out.println("Incorrect number of parametrs entered ...");
            throw new IndexOutOfBoundsException();
        }
    }
}
