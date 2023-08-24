package com.hei.noteheidemo.Controller;

import com.hei.noteheidemo.Entity.Group;
import com.hei.noteheidemo.Repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GroupRepository extends GenericRepository<Group> {
    public GroupRepository(Connection connection) {
        super(connection);
    }
    private Group extractGroupFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new Group(id , name) ;
    }
    @Override
    public void insert(Group toInsert) throws SQLException {
        String sql = "INSERT INTO \"group\" (name) VALUES (?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, toInsert.getName());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Group> findAll() throws SQLException {
        List<Group> groups = new ArrayList<>();
        String sql = "SELECT * FROM \"group\"";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Group allGroup = extractGroupFromResultSet(resultSet) ;
                groups.add(allGroup) ;
            }
        }
        return groups;
    }

    @Override
    public Optional<Group> findById(int id) throws SQLException {
        String sql = "SELECT * FROM \"group\" WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    return Optional.of(extractGroupFromResultSet(resultSet));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Group toUpdate) throws SQLException {
        String sql = "UPDATE \"group\" SET name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getName());
            preparedStatement.setInt(2, toUpdate.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM \"group\" WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
