package com.hei.noteheidemo.Repository;

import com.hei.noteheidemo.Entity.Note;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepository extends GenericRepository<Note> {
    public NoteRepository(Connection connection) {
        super(connection);
    }
    private Note extractNoteFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int subjectId = resultSet.getInt("subject_id");
        int studentId = resultSet.getInt("student_id");
        float note = resultSet.getFloat("note");
        return new Note(id, subjectId, studentId, note);
    }
    @Override
    public void insert(Note toInsert) throws SQLException {
        String sql = "INSERT INTO note (subject_id, student_id, note) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, toInsert.getSubject_id());
            preparedStatement.setInt(2, toInsert.getStudent_id());
            preparedStatement.setFloat(3, toInsert.getNote());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Note> findAll() throws SQLException {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM note";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Note note = extractNoteFromResultSet(resultSet);
                notes.add(note);
            }
        }
        return notes;
    }

    @Override
    public Optional<Note> findById(int id) throws SQLException {
        String sql = "SELECT * FROM note WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(extractNoteFromResultSet(resultSet));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Note toUpdate) throws SQLException {
        String sql = "UPDATE note SET subject_id = ?, student_id = ?, note = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, toUpdate.getSubject_id());
            preparedStatement.setInt(2, toUpdate.getStudent_id());
            preparedStatement.setFloat(3, toUpdate.getNote());
            preparedStatement.setInt(4, toUpdate.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM note WHERE id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<Note> getAllNotesForStudent(int studentId) throws SQLException {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM note WHERE student_id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Note note = extractNoteFromResultSet(resultSet);
                    notes.add(note);
                }
            }
        }
        return notes;
    }

    public List<Note> getAllNotesForSubject(int subjectId) throws SQLException {
        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM note WHERE subject_id = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, subjectId);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    Note note = extractNoteFromResultSet(resultSet);
                    notes.add(note);
                }
            }
        }
        return notes;
    }
    public float getAverageNoteForStudent(int studentId) throws SQLException {
        String sql = "SELECT AVG(note) AS average FROM note WHERE student_id = ?";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, studentId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getFloat("average");
                }
            }
        }
        return 0.0f;
    }
}
