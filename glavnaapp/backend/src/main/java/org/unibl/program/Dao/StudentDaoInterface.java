package org.unibl.program.Dao;

import org.unibl.program.Entity.Student;

import java.util.Collection;

public interface StudentDaoInterface {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
