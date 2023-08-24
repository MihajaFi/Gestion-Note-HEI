package com.hei.noteheidemo.Repository;

import com.hei.noteheidemo.Entity.Evaluations;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EvaluationsREPOSITORY extends GenericREPOSITORY<Evaluations> {

    public EvaluationsREPOSITORY(Connection connection) {
        super(connection);
    }
    private Evaluations extractEvaluationsFromResultSet(ResultSet resultSet) throws SQLException {

        java.sql.Date sqlDate = resultSet.getDate("date");
        int id = resultSet.getInt("id");
        LocalDate date = sqlDate.toLocalDate();
        String subject = resultSet.getString("subject");


        return new Evaluations(id , date ,subject) ;
    }
    @Override
    public void insert(Evaluations toInsert) throws SQLException {
        String sql = "INSERT INTO \"Evaluations\" (id , date , subject)" +
                "VALUES (?,?,?)" ;

        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1 ,toInsert.getId());
            ps.setDate(2 , Date.valueOf(toInsert.getDate()));
            ps.setString(3 , toInsert.getSubject()) ;

            ps.executeUpdate() ;
        }
    }

    @Override
    public List<Evaluations> findAll() throws SQLException {
        List<Evaluations> evaluation = new ArrayList<>();
        String sql = "SELECT * FROM \"Evaluations\" ";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Evaluations allEvaluation = extractEvaluationsFromResultSet(resultSet);
                evaluation.add(allEvaluation);
            }
        }
        return evaluation;
    }

    @Override
    public Optional<Evaluations> findById(int id) throws SQLException {
        String sql = "SELECT * FROM \"Evaluations\"  WHERE id = ?" ;

        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1 , id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return Optional.of(extractEvaluationsFromResultSet(rs)) ;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Evaluations toUpdate) throws SQLException {
        String sql = "UPDATE \"Evaluations\" SET date = ?, subject = ? WHERE id = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setDate(1 , Date.valueOf(toUpdate.getDate()));
            ps.setString(2 , toUpdate.getSubject());
            ps.setInt(3 , toUpdate.getId());

            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM  \"Evaluations\" WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
