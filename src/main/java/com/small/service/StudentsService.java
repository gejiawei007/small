package com.small.service;

import com.small.entity.Students;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentsService {

    int insert(Students students);

    List<Students> list(Map map);

    int update(Students students);

    int delete(int id);

    Students select(int id);
}
