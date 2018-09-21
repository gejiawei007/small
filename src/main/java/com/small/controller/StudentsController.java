package com.small.controller;

import com.small.entity.Students;
import com.small.serviceimpl.StudentsServiceimpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer",paramType = "query")
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public Students select (Integer id){

        Students students = studentsService.select(id);

        return  students;
    }

    @ApiOperation("修改学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="id",value = "用户ID",required = true ,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "用户名称",required = false,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "age",value = "用户年龄",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name = "city",value = "地址",required = false,dataType = "String",paramType = "query")
    })
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public int update(Students students){

        int count = studentsService.update(students);

        return count;
    }

    @ApiOperation("添加一个学生")
    /*@ApiImplicitParams({
            @ApiImplicitParam(name = "Students",value = "学生实体",dataType = "Students",paramType = "body")
    })*/
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public int insert(@RequestBody Students students){

        int count = studentsService.insert(students);

        return count;
    }
}
