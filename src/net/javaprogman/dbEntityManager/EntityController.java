package net.javaprogman.dbEntityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class EntityController<E, K>{

    public static Connection connection;

    public abstract List<E> getAll();
    public abstract void reportAll();
    public abstract E getEntityById(K id);
    public abstract E updateEntity(E entity);
    public abstract boolean createEntity(E entity);
    public abstract boolean deleteEntity(K id);

    public EntityController(Connection connection) {
        this.connection = connection;
    }

    public PreparedStatement getPreparedStatement(String sql){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    public void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
