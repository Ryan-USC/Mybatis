package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;
import org.example.vo.QueryParam;
import org.example.vo.ViewStudent;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(Integer id);

    List<Student> selectMultiParam(@Param("myname") String name, @Param("myage") Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudents();

    Map<Object,Object> selectMapById(@Param("stuId") Integer id);

    /*
    * 使用resultMap来定义映射关系
    * */
    List<Student> selectAllStudents();


    /*第一种模糊查询，在java代码中来指定like的内容*/
    List<Student> selectLikeOne(String name);
    /*在mapeer中拼接*/
    List<Student> selectLikeTwo(String name);

}
