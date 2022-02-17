package org.example.dao;

import org.example.domain.Student;

import java.util.List;

public interface StudentDao {
    // query all data in Student table
    public List<Student> selectStudents();

    // insert
    // parameter: student
    // return: int, num of row inserted
    public int insertStudents(Student student);

}
