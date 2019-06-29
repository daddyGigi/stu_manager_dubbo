package com.qf.service;

import com.qf.entity.Student;

import java.util.List;

/**
 * Created by  .Life on 2019/06/28/0028 20:42
 */
public interface IStudentService {

    int insert(Student student);

    List<Student> listAll();

    int delete(Integer id);

    int update(Student student);

    Student toupdate(Integer id);
}
