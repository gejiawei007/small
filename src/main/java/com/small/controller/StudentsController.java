package com.small.controller;

import com.small.entity.Students;
import com.small.serviceimpl.StudentsServiceimpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@Api(value = "StudentsController", description = "学生Controller")
public class StudentsController {

    @Autowired
    public StudentsServiceimpl studentsService;

    @ApiOperation("多条件查询学生列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "学生姓名",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "age",value = "年龄",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "city",value = "地址",dataType = "String",paramType = "query")
    })
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Students> list(Students students){

        Map map = new HashMap();
        map.put("name",students.getName());
        map.put("age",students.getAge());
        map.put("city",students.getCity());

        List<Students> list = studentsService.list(map);

        return list;
    }

    @ApiOperation("通过ID查询学生")
    //@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public Students select (Integer id){

        Students students = studentsService.select(id);

        return  students;
    }
}
