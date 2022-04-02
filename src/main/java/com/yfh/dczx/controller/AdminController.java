package com.yfh.dczx.controller;

import com.yfh.dczx.pojo.Student;
import com.yfh.dczx.service.ExcelService;
import com.yfh.dczx.service.UserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ExcelService excelService;

    @Autowired
    private UserService userService;

    @GetMapping("/toUpload")
    public String toUploadPage() {
        return "admin/upload";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file,Integer sheet,Integer startLine, Integer endLine) throws IOException, ServletException {

//        System.out.println(file.getOriginalFilename());
        Boolean aBoolean = excelService.excelToData(file.getOriginalFilename(), file, sheet, startLine, endLine);

//        request.getRequestDispatcher("/admin/list").forward(request, response);
        return "redirect:/admin/list";
    }

    @GetMapping("/admin/list")
    public String list(Model model) {
        List<Student> studentList = userService.getStudentList();
        model.addAttribute("students", studentList);
        return "admin/list";
    }

    @GetMapping("/admin/clear")
    public String clear(Model model) {
        userService.clearList();
        return "admin/list";
    }



}
