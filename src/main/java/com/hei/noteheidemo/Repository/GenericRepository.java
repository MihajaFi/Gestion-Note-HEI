package com.hei.noteheidemo.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class GenericREPOSITORY<Entity> {
    private Connection connection ;
    public GenericREPOSITORY(Connection connection){
        this.connection = connection ;
    }
    public Connection getConnection() {
        return connection;
    }

    public abstract void insert(Entity toInsert) throws SQLException;

    public abstract List<Entity> findAll() throws SQLException;

    public abstract Optional<Entity> findById(int id) throws SQLException;

    public abstract void update(Entity toUpdate) throws SQLException;

    public abstract void delete(int id) throws SQLException;

}
