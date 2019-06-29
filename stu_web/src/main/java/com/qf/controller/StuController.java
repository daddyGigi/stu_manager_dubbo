package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.service.IClassesService;
import com.qf.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by  .Life on 2019/06/28/0028 19:36
 */
@Controller
@RequestMapping("/stu")
public class StuController {
    @Reference
    private IClassesService classesService;
    @Reference
    private IStudentService studentService;


    @RequestMapping("/toinsert")
    public String toInsert(Model model){
        List<Classes> classes = classesService.queryAll();
        model.addAttribute("classes",classes);
        return "stuadd";
    }
    @RequestMapping("/insert")
    public String Insert(Student student){
        studentService.insert(student);
        return "redirect:/stu/list";
    }
    @RequestMapping("/list")
    public String listAll(Model model){
        List<Student> students = studentService.listAll();
        model.addAttribute("students",students);
        return "listAll";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        studentService.delete(id);
        return "redirect:/stu/list";
    }
    @RequestMapping("/toupdate")
    public String toUpdate(Integer id,Model model){
        Student student = studentService.toupdate(id);
        List<Classes> classes = classesService.queryAll();
        model.addAttribute("classes",classes);
        model.addAttribute("student",student);
        return "update";
    }
    @RequestMapping("/update")
    public String Update(Student student){
        studentService.update(student);
        return "redirect:/stu/list";
    }
}
