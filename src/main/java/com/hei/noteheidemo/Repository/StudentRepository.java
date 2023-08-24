package com.hei.noteheidemo.Repository;

import com.hei.noteheidemo.Entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class StudentRepository extends GenericRepository<Student> {
    public StudentRepository(Connection connection) {
        super(connection);
    }


    private Student extractStudentFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String lastName = resultSet.getString("last_name");
        String firstName= resultSet.getString("first_name");
        String studentNumber= resultSet.getString("student_number");
        int GroupId = resultSet.getInt("group_id") ;

        return new Student(id , lastName ,firstName ,studentNumber ,GroupId) ;
    }


    @Override
    public void insert(Student toInsert) throws SQLException {
        String sql = "INSERT INTO  student (last_name , first_name , student_number ,group_id) " +
                "VALUES (?,?,?,?)" ;

        try(PreparedStatement ps = getConnection().prepareStatement(sql)){

            ps.setString(1 , toInsert.getLast_name()) ;
            ps.setString(2 , toInsert.getFirst_name()) ;
            ps.setString(3 , toInsert.getStudent_number()) ;
            ps.setInt(4 ,toInsert.getGroup_id());


            ps.executeUpdate() ;
        }
    }

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student>  student = new ArrayList<>();
        String sql = "SELECT * FROM student ";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Student all = extractStudentFromResultSet(resultSet);
                student.add(all);
            }
        }
        return student;
    }

    @Override
    public Optional<Student> findById(int id) throws SQLException {
        String sql = "SELECT * FROM student  WHERE id = ?" ;

        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1 , id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return Optional.of(extractStudentFromResultSet(rs)) ;
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Student toUpdate) throws SQLException {
        String sql = "UPDATE student SET last_name = ?, first_name = ?, student_number = ? ,group_id = ? WHERE id = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, toUpdate.getLast_name());
            ps.setString(2, toUpdate.getFirst_name());
            ps.setString(3, toUpdate.getStudent_number());
            ps.setInt(4 ,toUpdate.getGroup_id());
            ps.setInt(5, toUpdate.getId());

            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM  student WHERE id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
