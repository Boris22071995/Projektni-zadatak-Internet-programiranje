package org.unibl.program.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.unibl.program.Dao.StudentDaoImpl;
import org.unibl.program.Entity.Student;

import java.util.Collection;
@Service
public class StudentService {

    @Autowired
    @Qualifier("fakeData")
    private StudentDaoImpl studentDaoImpl;

    public Collection<Student> getAllStudents() {
        return studentDaoImpl.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentDaoImpl.getStudentById(id);
    }

    public void removeStudentById(int id) {
        studentDaoImpl.removeStudentById(id);
    }

    public void updateStudent(Student student) {
        studentDaoImpl.updateStudent(student);
    }

    public void insertStudent(Student student) {
        studentDaoImpl.insertStudent(student);
    }
}
