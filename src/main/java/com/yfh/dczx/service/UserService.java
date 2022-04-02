package com.yfh.dczx.service;

import com.yfh.dczx.mapper.UserMapper;
import com.yfh.dczx.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<Student> getStudentList() {
        return userMapper.getUserList();
    }

    public Student getStudentByName(String name, String class_no) {
        System.out.println(name + "查询成绩");
        return userMapper.getStudentByName(name, class_no);
    }

    public void clearList() {
        System.out.println("清空表格信息");
        userMapper.clearList();
    }
}
