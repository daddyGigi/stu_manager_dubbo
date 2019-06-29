package com.qf.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.IStudentMapper;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by  .Life on 2019/06/28/0028 20:48
 */
@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private IStudentMapper studentMapper;
    @Reference
    private IClassesService classesService;

    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public List<Student> listAll() {
        List<Student> students = studentMapper.selectList(null);
        for (Student student : students) {
            Classes classes = classesService.queryById(student.getCid());
            student.setClasses(classes);
        }
        return students;
    }

    @Override
    public int delete(Integer id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public int update(Student student) {
        return studentMapper.updateById(student);
    }

    @Override
    public Student toupdate(Integer id) {
        Student student = studentMapper.selectById(id);
        Classes classes = classesService.queryById(student.getCid());
        student.setClasses(classes);
        return student;
    }

}
