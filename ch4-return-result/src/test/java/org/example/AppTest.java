package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.example.vo.QueryParam;
import org.example.vo.ViewStudent;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(11111);
        System.out.println(student);
    }
    @Test
    public void testMultiParam(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiParam("ryan",42);

        students.forEach(student -> System.out.println(student));

        sqlSession.close();
    }

    @Test
    public void testSelectViewStudent(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        ViewStudent student = dao.selectStudentReturnViewStudent(11111);
        System.out.println(student);
    }
    @Test
    public void testSelectCountStudents(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        int count = dao.countStudents();
        System.out.println(count);
    }

    @Test
    public void testSelectMapById(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<Object,Object> map = dao.selectMapById(11111);
        System.out.println(map);
    }

    @Test
    public void testSelectAllStudents(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectAllStudents();
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectLikeOne(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "%ry%";
        List<Student> students = dao.selectLikeOne(name);
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testSelectLikeTwo(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "ry";
        List<Student> students = dao.selectLikeTwo(name);
        students.forEach(student -> System.out.println(student));
    }
}
