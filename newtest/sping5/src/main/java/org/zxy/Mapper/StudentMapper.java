package org.zxy.Mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.zxy.domain.Student;

import java.util.List;

public interface StudentMapper {
    @Select("SELECT * FROM TB_STUDENT WHERE CLAZZ_ID= #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age")
    })
    List<Student> selectByClazzId(Integer clazz_id);
}
