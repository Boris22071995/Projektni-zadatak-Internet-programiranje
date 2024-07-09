package org.unibl.program.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.unibl.program.Entity.Student;

import java.util.ArrayList;
import java.util.Collection;
@Repository
@Qualifier("mongoData")
public class MongoStudentImpl implements StudentDaoInterface{
    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<Student>(){
            {
                add(new Student(1,"MongoBoris","IT"));
            }
        };

    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void insertStudent(Student student) {

    }
}
