package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSelectIfStudent(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("ryan");
        student.setAge(13);
        List<Student> list = dao.selectStudentIf(student);
        list.forEach(student1 -> System.out.println(student1));
    }

    @Test
    public void testSelectWhereStudent(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("ryan");
        student.setAge(13);
        List<Student> list = dao.selectStudentIf(student);
        list.forEach(student1 -> System.out.println(student1));
    }

    @Test
    public void testForeachOne(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Integer> list = new LinkedList<>();
        list.add(11111);
        list.add(1002);
        list.add(1001);

        List<Student> students = dao.selectForeachOne(list);
        students.forEach(student -> System.out.println(student));

    }

    @Test
    public void testForeachTwo(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> list = new LinkedList<>();
        Student s1 = new Student();
        s1.setId(1001);
        list.add(s1);

        Student s2 = new Student();
        s2.setId(11111);
        list.add(s2);

        List<Student> students = dao.selectForeachTwo(list);
        students.forEach(student -> System.out.println(student));

    }

}
