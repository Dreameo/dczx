package com.yfh.dczx.mapper;

import com.yfh.dczx.pojo.Student;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 批量增加
     */
    int insertByList(@Param("studentList") List<Student> studentList);

    @Insert("insert into t_student values (null, #{examNo},#{stuName},#{chinese},#{math},#{english},#{politics},#{history},#{geography},#{biology})")
    int insertStudent(Student student);

    @Select("select count(*) from t_student where stu_name = #{name}")
    int selectByName(@Param("name") String name);

    @Update("update t_student set exam_no = #{examNo}, chinese=#{chinese},math=#{math}," +
            "english=#{english},politics=#{politics},history=#{history}," +
            "geography=#{geography},biology=#{biology} where stu_name=#{stuName}")
    int updateStudent(Student student);

    @Select("select * from t_student")
    List<Student> getUserList();


    @Select("select * from t_student where stu_name = #{name}")
    Student getStudentByName(@Param("name") String name);


}
