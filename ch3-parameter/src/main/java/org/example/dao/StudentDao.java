package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;
import org.example.vo.QueryParam;

import java.util.List;

public interface StudentDao {

    /*
    * 一个简单类型的参数：
    *   简单类型：mybatis把java的基本数据类型和string都叫简单类型
    *
    * 在mapper文件中获取简单类型的一个参数的值，使用#{任意字符}*/
    public Student selectStudentById(Integer id);

    List<Student> selectMultiParam(@Param("myname") String name, @Param("myage") Integer age);

    /*
    * 多个参数，使用java对象作为接口中方法的参数*/
    List<Student> selectMultiObject(QueryParam param);
}
