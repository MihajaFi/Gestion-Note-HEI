package com.hei.noteheidemo.Repository;

import com.hei.noteheidemo.Entity.Subject;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SubjectRepository extends GenericRepository<Subject> {
    public SubjectRepository(Connection connection) {
        super(connection);
    }
    private Subject extractSubjectFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String SubjectCode = resultSet.getString("subject_code");
        int CoefSubject = resultSet.getInt("coef_subject") ;
        return new Subject(id , SubjectCode , CoefSubject) ;
    }
    @Override
    public void insert(Subject toInsert) throws SQLException {
        String sql = "INSERT INTO subject (subject_code, coef_subject) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, toInsert.getSubject_code());
            preparedStatement.setInt(2, toInsert.getCoef_subject());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Subject> findAll() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String sql = "SELECT * FROM subject";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Subject allSubject = extractSubjectFromResultSet(resultSet) ;
                subjects.add(allSubject);
            }
        }
        return subjects;
    }

    @Override
    public Optional<Subject> findById(int id) throws SQLException {
        String sql = "SELECT * FROM subject WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {

                    return Optional.of(extractSubjectFromResultSet(resultSet));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Subject toUpdate) throws SQLException {
        String sql = "UPDATE subject SET subject_code = ?, coef_subject = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, toUpdate.getSubject_code());
            preparedStatement.setInt(2, toUpdate.getCoef_subject());
            preparedStatement.setInt(3, toUpdate.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM subject WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
