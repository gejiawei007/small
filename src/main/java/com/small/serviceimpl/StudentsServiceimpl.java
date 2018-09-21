package com.small.serviceimpl;

import com.small.dao.StudentsMapper;
import com.small.entity.Students;
import com.small.entity.StudentsExample;
import com.small.service.StudentsService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "StudentsService")
public class StudentsServiceimpl implements StudentsService {

    @Autowired
    public StudentsMapper StudentsDao;

    /**
     *  添加一个学生
     * @param students
     * @return
     */
    @Override
    public int insert(Students students) {

        int count = StudentsDao.insert(students);

        return count;
    }

    /**
     * 通过map多条件查询学生集合
     * @param map
     * @return
     */
    @Override
    public List<Students> list(Map map) {

        List<Students> list = StudentsDao.list(map);
        return list;
    }

    /**
     * 修改学生
     * @param students
     * @return
     */
    @Override
    public int update(Students students) {

        StudentsExample studentsExample = new StudentsExample();
        StudentsExample.Criteria criteria = studentsExample.createCriteria();
        criteria.andIdEqualTo(students.getId());

        long count = StudentsDao.countByExample(studentsExample);

        if (count>0){
            Students studentsInitial = new Students();
            studentsInitial.setId(students.getId());
            studentsInitial.setName(students.getName());
            studentsInitial.setAge(students.getAge());
            studentsInitial.setCity(students.getCity());

            int count2 = StudentsDao.updateByPrimaryKeySelective(studentsInitial);

            return count2;
        }else {

            return 0;
        }

    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    @Override
    public int delete(int id) {
        int count = StudentsDao.deleteByPrimaryKey(id);
        return count;
    }

    /**
     * 通过ID查询出一个学生
     * @param id
     * @return
     */
    @Override
    public Students select(int id) {
        Students students = StudentsDao.selectByPrimaryKey(id);
        return students;
    }
}
