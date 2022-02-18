package org.example;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testSelectStudents(){
//        使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
//        getMapper能获取dao接口的实现类对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

//        调用dao的方法，执行数据库的操作
        List<Student> students = dao.selectStudents();
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(11111);
        student.setName("momo");
        student.setEmail("iono@iii.com");
        student.setAge(33);
        int nums = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println(nums);
    }
}
