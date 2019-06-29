package com.qf.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.ClassesMapper;
import com.qf.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * Created by  .Life on 2019/06/28/0028 19:50
 */
@Service
public class ClassServiceImpl implements IClassesService {
    @Autowired
    ClassesMapper classesMapper;
    @Override
    public List<Classes> queryAll() {
        return classesMapper.selectList(null);
    }

    @Override
    public Classes queryById(Integer id) {
        return classesMapper.selectById(id);
    }
}
