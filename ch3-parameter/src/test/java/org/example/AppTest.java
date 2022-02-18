package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.example.vo.QueryParam;
import org.junit.Test;

import java.util.List;

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
    public void testMultiObject(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setParamAge(28);
        param.setParamName("ryan");
        List<Student> students = dao.selectMultiObject(param);

        students.forEach(student -> System.out.println(student));

        sqlSession.close();
    }


}
