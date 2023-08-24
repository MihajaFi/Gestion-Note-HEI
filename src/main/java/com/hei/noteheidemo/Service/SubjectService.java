package com.hei.noteheidemo.Service;

import com.hei.noteheidemo.Entity.Subject;
import com.hei.noteheidemo.Repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject createSubject(Subject subject) {
        try {
            subjectRepository.insert(subject);
            return subject;
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when creating Subject " + subject + ": " + e);
        }
    }

    public List<Subject> getAllSubjects() {
        try {
            return subjectRepository.findAll();
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching Subject " + e);
        }
    }

    public Optional<Subject> getSubjectById(int id) {
        try {
            return subjectRepository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when fetching Subject " + id + ": " + e);
        }
    }

    public Subject updateSubject(Subject subject) {
        try {
            subjectRepository.update(subject);
            return subject;
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when updating Subject  " + subject + ": " + e);
        }
    }

    public void deleteSubject(int id) {
        try {
            subjectRepository.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException("There was a error when deleting Subject " + id + ": " + e);
        }
    }
}
