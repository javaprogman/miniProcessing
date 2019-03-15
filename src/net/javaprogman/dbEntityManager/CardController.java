package net.javaprogman.dbEntityManager;

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
                lc.add(new Card(cardNumber, pin, account_id));

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
    public Card getEntityById(Integer id) {
        return null;
    }

    @Override
    public Card updateEntity(Card card) {
        return null;
    }

    @Override
    public boolean createEntity(Card card) {
        return false;
    }

    @Override
    public boolean deleteEntity(Integer id) {
        return false;
    }
}
