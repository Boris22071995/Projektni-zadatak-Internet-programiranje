package org.unibl.program.Dao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
@Qualifier("fakeData")
public class StudentDaoImpl implements StudentDaoInterface {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {

            {
                put(1,new Student(1,"Boris","IT"));
                put(2,new Student(2,"Tamara","Economy"));
                put(3,new Student(3,"Sara","Geodesy"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(),student);
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
