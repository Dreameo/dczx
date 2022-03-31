package com.yfh.dczx.controller;

import com.yfh.dczx.pojo.Student;
import com.yfh.dczx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String test() {
        return "student/index";
    }

    @GetMapping("/query")
    public String queryStudentByName(String name, Model model) {
        Student student = userService.getStudentByName(name);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/result";
        }
        model.addAttribute("msg", "未查到结果，检查名字是否输入错误！");
        return "student/index";
    }
}
