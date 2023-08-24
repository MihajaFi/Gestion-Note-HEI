package com.hei.noteheidemo.Repository;

import com.hei.noteheidemo.Entity.Grade;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GradeREPOSITORY extends  GenericREPOSITORY<Grade> {

    public GradeREPOSITORY(Connection connection) {
        super(connection);
    }
    private Grade extractGradeFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String subject = resultSet.getString("subject");
        Float score= resultSet.getFloat("score");
        int IdStudent = resultSet.getInt("student_id");
        int IdEvaluation = resultSet.getInt("evaluations_id");

        return new Grade(id , subject ,score ,IdStudent , IdEvaluation) ;
    }
    @Override
    public void insert(Grade toInsert) throws SQLException {
        String sql = "INSERT INTO  \"Grade\" (id ,subject , score , student_id , evaluations_id) " +
                "VALUES (?,?,?,?,?)" ;

        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1 , toInsert.getId());
            ps.setString(2 ,toInsert.getSubject());
            ps.setFloat(3 ,toInsert.getScore());
            ps.setInt(4 , toInsert.getStudent_id());
            ps.setInt(5, toInsert.getEvaluations_id());

            ps.executeUpdate() ;
        }
    }

    @Override
    public List<Grade> findAll() throws SQLException {
        List<Grade>  grade = new ArrayList<>();
        String sql = "SELECT * FROM \"Grade\" ";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Grade allGrade = extractGradeFromResultSet(resultSet);
                grade.add(allGrade);
            }
        }
        return grade;
    }

    @Override
    public Optional<Grade> findById(int id) throws SQLException {
        String sql = "SELECT * FROM \"Grade\"  WHERE id = ?" ;

        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1 , id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return Optional.of(extractGradeFromResultSet(rs)) ;
                }
            }
        }
        return Optional.empty();
    }
    public Optional<Grade> findBySubject(String subject ,int student_id) throws SQLException {
        String sql = "SELECT * FROM \"Grade\"  WHERE subject = ? AND student_id = ?" ;

        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1 , subject);
            ps.setInt(2 , student_id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return Optional.of(extractGradeFromResultSet(rs)) ;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Grade toUpdate) throws SQLException {
        String sql = "UPDATE \"Grade\" SET subject = ?, score = ?, student_id = ? , evaluations_id = ? WHERE id = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1 , toUpdate.getSubject());
            ps.setFloat(2 , toUpdate.getScore());
            ps.setInt(3, toUpdate.getStudent_id());
            ps.setInt(4 , toUpdate.getEvaluations_id());
            ps.setInt(5 , toUpdate.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM  \"Grade\" WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
