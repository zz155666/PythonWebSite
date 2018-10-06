package org.zxy.Mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.zxy.domain.Clazz;

public interface ClazzMapper {
    @Select("SELECT * FROM TB_CLAZZ WHERE ID=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "code",property = "code"),
            @Result(column = "id",property = "students",
            many = @Many(select = "org.zxy.Mapper.StudentMapper.selectByClazzId",
            fetchType = FetchType.LAZY))
    })
    Clazz selectById(Integer id);
}
