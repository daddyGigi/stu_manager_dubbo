package com.qf.service;

import com.qf.entity.Classes;

import java.util.List;

/**
 * Created by  .Life on 2019/06/28/0028 19:46
 */
public interface IClassesService {
    List<Classes> queryAll();

    Classes queryById(Integer id);
}
